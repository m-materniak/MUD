package com.mud;

import com.mud.Entities.GameWorld;
import com.mud.Entities.UserAccount;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class SystemCommandHandler extends CommandHandler {
    ClientConnection clientConnection;
    private UserRepository userRepository;
    private GameWorld gameWorld;

    private String helpString = "Available commands:\r\n" +
                    "\tregister new_login new_password\r\n" +
                    "\tlogin your_login your_password\r\n" +
                    "\tlogout\r\n" +
                    "\thelp\r\n";

    public SystemCommandHandler(ClientConnection clientConnection, UserRepository userRepository, GameWorld gameWorld){
        this.clientConnection = clientConnection;
        this.userRepository = userRepository;
        this.gameWorld = gameWorld;
    }

    @Override
    public void ExecuteCommand(String command) {
        if (command == null) {
            Welcome();
            return;
        }

        restOfCommand = command;
        String verb = TakeNextWord();

        if(verb.equals("login")){
            Login();
        } else if (verb.equals("register")){
            Register();
        } else if(verb.equals("logout")){
            Logout();
        } else if(verb.equals("help")){
            Help();
        }
    }

    @Override
    public String GetHelpString() {
        return helpString;
    }

    private void Welcome() {
        clientConnection.Send("Welcome to the OpenMud.\r\n" +
                "\r\n"
                + GetHelpString());
    }

    protected void Logout() {
        clientConnection.Send("Ha, ha. You can't log out.");
    }

    protected void Register() {
        String login = TakeNextWord();
        String password = TakeNextWord();
        if (userRepository.CreateUser(login, password, gameWorld) != null){
            clientConnection.Send("Account " + login + " was successfully created.");
        } else {
            clientConnection.Send("Couldn't create account " + login + ".");
        }
    }

    protected void Login() {
        String login = TakeNextWord();
        String password = TakeNextWord();
        UserAccount account = userRepository.LogIn(login, password, clientConnection);
        if (account != null) {
            clientConnection.player = account.player;
            account.player.connection = clientConnection;
            clientConnection.Send("You are logged in as " + account.player.Name);
            gameWorld.AddPerson(account.player);
            UserCommandHandler userCommandHandler = new UserCommandHandler(this, clientConnection, gameWorld);
            clientConnection.commandHandler = userCommandHandler;
            userCommandHandler.ExecuteCommand(null);
        }
        else{
            clientConnection.Send("Wrong login or password");
        }
    }
}
