package com.mud;

import com.mud.Entities.Cell;
import com.mud.Entities.GameWorld;
import com.mud.Entities.Player;
import com.mud.Entities.UserAccount;
import io.netty.channel.Channel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krzysiek on 2014-11-09.
 */
public class UserRepository {
    private List<UserAccount> userAccounts = new ArrayList<UserAccount>();

    public UserAccount LogIn(String login, String password, ClientConnection clientConnection){
        UserAccount account = GetAccount(login);
        if (account != null && account.password.equals(password)){
            DisconnectUser(account);
            account.clientConnection = clientConnection;
            account.clientConnection.player = account.player;
            return account;
        }
        return null;
    }

    private UserAccount GetAccount(String login) {
        for (UserAccount account : userAccounts){
            if (account.login.equals(login)){
                return account;
            }
        }
        return null;
    }

    private void DisconnectUser(UserAccount account) {
        if (account.clientConnection != null) {
            account.clientConnection.Disconnect();
            account.clientConnection = null;
        }
    }

    public UserAccount CreateUser(String name, String password, GameWorld gameWorld) {
        UserAccount account = Register(name, password);
        Player player = new Player(gameWorld);
        player.Name = name;
        player.setLocation(gameWorld.getStartingCell());
        account.player = player;
        return account;
    }

    private UserAccount Register(String login, String password) {
        UserAccount account = GetAccount(login);
        if (account != null)
            return null;

        account = new UserAccount();
        account.login = login;
        account.password = password;
        userAccounts.add(account);
        return account;
    }
}
