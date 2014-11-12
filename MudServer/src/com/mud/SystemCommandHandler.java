package com.mud;

import com.mud.Entities.UserAccount;

/**
 * Created by krzysiek on 2014-11-08.
 */
public class SystemCommandHandler extends CommandHandler {
    ClientConnection clientConnection;
    private UserRepository userRepository;

    public SystemCommandHandler(ClientConnection clientConnection, UserRepository userRepository){
        this.clientConnection = clientConnection;
        this.userRepository = userRepository;
    }

    @Override
    public void ExecuteCommand(String command) {
        if (command == null) {
            Welcome();
            return;
        }

        String[] parts = command.split("\\s+");
        String verb = parts[0];

        if(verb.equals("login")){
            Login(parts);
        } else if (verb.equals("register")){
            Register(parts);
        } else if(verb.equals("logout")){
            Logout();
        }
    }

    private void Welcome() {
        clientConnection.Send("Welcome.");
    }

    protected void Logout() {
        clientConnection.Send("Ha, ha. You can't log out.");
    }

    protected void Register(String[] parts) {
        String login = parts[1];
        String password = parts[2];
        if (userRepository.Register(login, password) != null){
            clientConnection.Send("Account " + login + " was successfully created.");
        } else {
            clientConnection.Send("Couldn't create account " + login + ".");
        }
    }

    protected void Login(String[] parts) {
        String login = parts[1];
        String password = parts[2];
        UserAccount account = userRepository.LogIn(login, password, clientConnection);
        if (account != null) {
            clientConnection.player = account.player;
            clientConnection.Send("You are logged in as " + account.player.Name);
            UserCommandHandler userCommandHandler = new UserCommandHandler(this, clientConnection);
            clientConnection.commandHandler = userCommandHandler;
            userCommandHandler.ExecuteCommand(null);
        }
        else{
            clientConnection.Send("Wrong login or password");
        }
    }
}
