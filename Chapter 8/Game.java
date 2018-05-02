import java.util.*;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    // private Room currentRoom;
    private Stack<Command> commands;
    private Player player;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        parser = new Parser();
        commands = new Stack<>();
        player = new Player("Joe");
        createRooms();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office;
        
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);
        
        // add items
        outside.addItem(new Item("tree", "big cherry tree", 10, false));
        outside.addItem(new Item("table", "wooden lunch table", 5, false));
        theater.addItem(new Item("chair", "soft, cushiony reclining chair", 5, true));
        theater.addItem(new Item("popcorn", "buttery, chewy yellow snack", 1, true));
        pub.addItem(new Item("beer", "a nice glass of Budweiser", 2, true));
        lab.addItem(new Item("labcoat", "clean white coat for research purposes", 3, true));
        office.addItem(new Item("desk", "large wooden table with drawers", 5, false));
        office.addItem(new Item("computer", "desktop computer running Windows 10", 4, true));
        player.setCurrentRoom(outside);  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(player.getCurrentRoom().getLongDescription());
        player.getCurrentRoom().displayItems();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
            commands.push(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("back")) {
            if (commands.size() == 0) System.out.println("Can't go back.");
            else {
                String prev = commands.pop().getSecondWord();
                System.out.println(prev);
                if (prev.equals("north")) goRoom(new Command("go", "south"));
                else if (prev.equals("south")) goRoom(new Command("go", "north"));
                else if (prev.equals("east")) goRoom(new Command("go", "west"));
                else if (prev.equals("west")) goRoom(new Command("go", "east"));
            }
        }
        else if (commandWord.equals("take")) {
            takeItem(command);
        }
        else if (commandWord.equals("drop")) {
            dropItem(command);
        }
        else if (commandWord.equals("items")) {
            player.displayItems();
        }
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = player.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            player.setCurrentRoom(nextRoom);
            System.out.println(player.getCurrentRoom().getLongDescription());
            player.getCurrentRoom().displayItems();
        }
    }
    
    private void takeItem(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what to take...
            System.out.println("Take what?");
            return;
        }
        
        String take = command.getSecondWord();
        
        for (Item item : player.getCurrentRoom().getItems()) {
            if (item.getName().equals(take)) {
                if (!item.takeable()) {
                    System.out.println("Not allowed to take!");
                    return;
                }
                else if (!player.takeItem(item)) {
                    System.out.println("You are carrying too much weight!");
                    return;
                }
                player.getCurrentRoom().removeItem(item);
                System.out.println(player.getCurrentRoom().getLongDescription());
                player.getCurrentRoom().displayItems();
                return; 
            }
        }
        
        System.out.println("Item does not exist!");
    }
    
    
    private void dropItem(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what to drop...
            System.out.println("Drop what?");
            return;
        }
        
        String drop = command.getSecondWord();
        for (Item item : player.getItems()) {
            if (item.getName().equals(drop)) {
                player.dropItem(item);
                player.getCurrentRoom().addItem(item);
                System.out.println(player.getCurrentRoom().getLongDescription());
                player.getCurrentRoom().displayItems();
                return;
            }
        }
        
        System.out.println("Item does not exist!");        
    }
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
