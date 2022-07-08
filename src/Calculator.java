import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args)
    {

        //region Variable Declaration
        Scanner myScanner = new Scanner(System.in);

        //declare all floats
        float w, h, tinSize, tinCover, m, tinsNeeded, ans, doorW, doorH, totalDoorSize, totalWindowSize, totalRadiatorSize,
                totalSocketSize, windowH , windowW, socketW, socketH, totalObjSize, totalM, tinsNeededTotal, totalTinCover, remainingPaint, radiatorW, radiatorH;
        //give floats a 0.f value
        totalDoorSize = totalSocketSize = totalRadiatorSize = totalWindowSize = totalM = tinsNeededTotal = totalObjSize = windowH = 0.f;

        //declare all ints and give them a null value
        int c, roundAns, numWalls, numWindows, numDoors, numSockets, numRadiators;
        //give all ints a 0 value
        numWindows = numDoors = numSockets = numRadiators = 0;

        String obs, shape;
        ArrayList<ArrayList<String>> listOLists = new ArrayList<>();
        boolean invalid;
        //endregion

        //region Number of Walls and Paint Tin Specification Input
        //Get the number of walls and convert into an int
        System.out.println("How many walls are you painting?");
        numWalls = Integer.parseInt(myScanner.nextLine());

        //Get the size of the paint tin and convert into a floating number
        System.out.println("How big is the paint tin in litres?");
        tinSize = Float.parseFloat(myScanner.nextLine());

        //Get the coverage of the paint tin and convert into a floating number
        System.out.println("How many metres square does one litres of the tin paint?");
        tinCover = Float.parseFloat(myScanner.nextLine());
        //endregion

        for (int i = 0; i < numWalls; i++) {

            //region Inputting Numbers and Sizes of Obstacles
            System.out.println("For WALL NUMBER " + (i + 1));

            do {

                //Ask if the wall has any obstacles
                System.out.println("Does the wall your painting have any obstacles? [Y/N]");
                obs = myScanner.nextLine();
                //emptyWall = obs.startsWith("Y");

                switch (obs) {
                    case "Y", "y" -> {
                        //Get the number of windows on the wall
                        System.out.println("How many windows on the wall you are painting?");
                        numWindows = Integer.parseInt(myScanner.nextLine());

                        //Get the number of doors on the wall
                        System.out.println("How many doors on the wall you are painting?");
                        numDoors = Integer.parseInt(myScanner.nextLine());

                        //Get the number of windows on the wall
                        System.out.println("How many sockets on the wall you are painting?");
                        numSockets = Integer.parseInt(myScanner.nextLine());

                        //Get the number of radiators on the wall
                        System.out.println("How many radiators on the wall you are painting?");
                        numRadiators = Integer.parseInt(myScanner.nextLine());
                    }
                    case "N", "n" -> System.out.println("No Obstacles on Wall " + (i+1));
                    default -> obs = " ";
                }

            }while (obs.startsWith(" ") );

            if (numDoors > 0 )
            {
                for (int j = 0; j < numDoors; j++) {
                    System.out.println("For Door Number " + (j + 1));

                    //Get the width of the wall and convert into a floating number
                    System.out.println("How wide is the door in metres?");
                    doorW = Float.parseFloat(myScanner.nextLine());

                    //Get the height of the wall and convert into a floating number
                    System.out.println("How tall is the door in metres?");
                    doorH = Float.parseFloat(myScanner.nextLine());

                    totalDoorSize += (doorH * doorW);
                }
            }

            if (numWindows > 0 )
            {
                for (int j = 0; j < numWindows; j++) {
                    System.out.println("For Window Number " + (j + 1));

                    do {

                        //Get the Window Shape.
                        System.out.println("What Shape is the window? (Semi-Circle, Circle, Triangle, Rectangle, Pentagon, Hexagon) ");
                        shape = myScanner.nextLine();

                        invalid = !shape.equalsIgnoreCase("rectangle") && !shape.equalsIgnoreCase("semi-circle")
                                && !shape.equalsIgnoreCase("circle") && !shape.equalsIgnoreCase("triangle")
                                && !shape.equalsIgnoreCase("pentagon") && !shape.equalsIgnoreCase("hexagon")
                                && !shape.equalsIgnoreCase("heptagon") && !shape.equalsIgnoreCase(("octagon"));

                    }while (invalid);

                    if (shape.equalsIgnoreCase("circle") || shape.equalsIgnoreCase("semi-circle")) {
                        //Get the diameter of the window and convert into a floating number
                        System.out.println("How big is the diameter of the window in metres?");
                        windowW = Float.parseFloat(myScanner.nextLine());

                    } else if (shape.equalsIgnoreCase("triangle") || shape.equalsIgnoreCase("rectangle")){
                        //Get the width of the wall and convert into a floating number
                        System.out.println("How wide is the window in metres?");
                        windowW = Float.parseFloat(myScanner.nextLine());

                        //Get the height of the wall and convert into a floating number
                        System.out.println("How tall is the window in metres?");
                        windowH = Float.parseFloat(myScanner.nextLine());

                    } else if (shape.equalsIgnoreCase("hexagon") || shape.equalsIgnoreCase("pentagon")) {
                        //Get the size of a side of the window and convert into a floating number
                        System.out.println("How big is one side of the window in metres?");
                        windowW = Float.parseFloat(myScanner.nextLine());
                    } else { break; }//more shapes can go here

                    switch (shape) {
                        case "circle", "Circle"             -> totalWindowSize += Math.PI / 4 * Math.pow(windowW, 2);
                        case "semi-circle" , "Semi-Circle"  -> totalWindowSize += Math.PI / 8 * Math.pow(windowW, 2);
                        case "triangle" , "Triangle"        -> totalWindowSize += (windowH * windowW) / 2;
                        case "rectangle" , "Rectangle"      -> totalWindowSize += (windowH * windowW);
                        case "pentagon" , "Pentagon"        -> totalWindowSize += (0.25f * ((Math.sqrt(5 * (5 + 2 * (Math.sqrt(5)) * Math.pow(windowW, 2))))));
                        case "hexagon" , "Hexagon"          -> totalWindowSize += (0.5f * (3 * Math.sqrt(3))) * Math.pow(windowW, 2);
                        case "heptagon" , "Heptagon"        -> totalWindowSize += ((7f / 4f) * Math.pow(windowW, 2)) * ((1f / (Math.tan(180))) / 7);
                        case "octagon" , "Octagon"          -> totalWindowSize += 2f * (1 + Math.sqrt(2)) * Math.pow(windowW, 2);
                        case "nonagon" , "Nonagon"          -> totalWindowSize += ((9f / 4f) * Math.pow(windowW, 2)) * ((1f / (Math.tan(180))) / 9);
                        case "decagon" , "Decagon"          -> totalWindowSize += ( ((5f/2f) * Math.pow(windowW,2)) * (Math.sqrt(5+ 2*(Math.sqrt(5)) )) );
                        default -> {                         }
                    }

                }
            }

            if (numSockets > 0 )
            {
                for (int j = 0; j < numSockets; j++) {
                    System.out.println("For Socket Number " + (j + 1));

                    //Get the width of the wall and convert into a floating number
                    System.out.println("How wide is the socket in metres?");
                    socketW = Float.parseFloat(myScanner.nextLine());

                    //Get the height of the wall and convert into a floating number
                    System.out.println("How tall is the socket in metres?");
                    socketH = Float.parseFloat(myScanner.nextLine());

                    totalSocketSize += (socketH * socketW);

                }
            }

            if (numRadiators > 0 )
            {
                for (int j = 0; j < numRadiators; j++) {
                    System.out.println("For Radiator Number " + (j + 1));

                    //Get the width of the wall and convert into a floating number
                    System.out.println("How wide is the Radiator in metres?");
                    radiatorW = Float.parseFloat(myScanner.nextLine());

                    //Get the height of the wall and convert into a floating number
                    System.out.println("How tall is the Radiator in metres?");
                    radiatorH = Float.parseFloat(myScanner.nextLine());

                    totalRadiatorSize += (radiatorH * radiatorW);

                }
            }


            //endregion

            //region Wall Size and Coat Requirement Input
            //Get the width of the wall and convert into a floating number
            System.out.println("How wide is the wall in metres?");
            w = Float.parseFloat(myScanner.nextLine());

            //Get the height of the wall and convert into a floating number
            System.out.println("How tall is the wall in metres?");
            h = Float.parseFloat(myScanner.nextLine());

            //Get the number of coats the wall needs and convert into a floating number
            System.out.println("How many coats does the wall need?");
            c = Integer.parseInt(myScanner.nextLine());
            //endregion

            for (int j = 0; j < c; j++)
            {
                m = (w * h) - totalObjSize;
                totalM += m;
            }

            //region Working out tins needed and remainder of tin
            totalTinCover = tinSize * tinCover;
            tinsNeeded = totalM / totalTinCover;
            tinsNeededTotal += tinsNeeded;
            tinsNeeded += 0.5f;

            ans = tinsNeeded;
            roundAns = Math.round(ans);
            remainingPaint = (roundAns - (tinsNeeded - 0.5f)) * 100;
            //endregion

            System.out.println("You will need " + roundAns + " number of tins to paint wall number " + (i + 1) +
                    " with dimensions of " + h + " metres tall and " + w + " metres wide with " + c + " number of coats. ");

            //region List of Variables getting made
            ArrayList<String> singleList = new ArrayList<>();
            singleList.add(String.valueOf(i + 1));
            singleList.add(String.valueOf(w));
            singleList.add(String.valueOf(h));
            singleList.add(String.valueOf(w*h));
            singleList.add(String.valueOf(c));
            singleList.add(String.valueOf(numDoors));
            singleList.add(String.valueOf(totalDoorSize));
            singleList.add(String.valueOf(numWindows));
            singleList.add(String.valueOf(totalWindowSize));
            singleList.add(String.valueOf(numSockets));
            singleList.add(String.valueOf(totalSocketSize));
            singleList.add(String.valueOf(numRadiators));
            singleList.add(String.valueOf(totalRadiatorSize));
            singleList.add(String.valueOf(roundAns));
            singleList.add((remainingPaint) + "%");
            listOLists.add(singleList);

            //endregion

            //reset variables for the next wall.
            numDoors = numRadiators = numSockets = numWindows = 0;

        }

        //region Working out Total number of Tins needed and the Remainder of Last Tin
        tinsNeededTotal += 0.5f;
        ans = tinsNeededTotal;
        roundAns = Math.round(ans);

        remainingPaint = (roundAns - (tinsNeededTotal - 0.5f)) * 100;
        //endregion

        //region Creating an array of the ListOfLists
        String[][] arr = new String[listOLists.size()][];

        int i = 0;
        for (List<String> l: listOLists) {
            arr[i++] = l.toArray(new String[l.size()]);
        }
        //endregion

        //region Printing out the Array of Lists
        System.out.println ("Wall#/Width/Height/Area/Coats/Doors/Area/Windows/Area/Sockets/Area/Radiators/Area/Tins/RemainingPaint");

        for (String[] floats : arr) {
            System.out.println(Arrays.deepToString(floats));
        }
        //endregion

        System.out.println("For all " + numWalls + " walls, you will need " + roundAns + " number of tins overall, with " + remainingPaint + "% of a tin remaining! ");
    }
}