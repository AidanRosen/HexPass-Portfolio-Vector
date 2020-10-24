How to run VectorCalculatorUI

Please change the configuration to VectorCalculatorUI, then press run (the green play button). 

After entering the calculator, you will see two blue squares. Click on them and type a number into each. 
You MUST MUST MUST press the enter key twice after typing in your value BEFORE pressing the calculation button in 
the lower right. Not doing so causes a tricky bug that we will be working on fixing next week. 

After typing values into both squares BEFORE pressing create vector, press the create vector button (which has the 
text "click me to calculate vector")
After clicking that button at the top will be a number. This is the magnitude of the vector. 
In the bottom left on the blue-green square is the direction of the vector in degrees. 

End the program by exiting the window. 

Bugs and warnings: It is IMPERATIVE that you press enter twice after typing each value 


How to run graphing calculator

Please change the configuration to GraphMain, then press run 




Notes for the future:
    Next week, we must create a main menu. Per the project plan, it will begin in the terminal then go into the menu. 

This code was worked on by Aidan Rosen and Andrew Hale, and can all be found under the vector_calc folder. 
        Andrew built the VectorcalculatorUI file
        Aidan built the VectorCreate file which contains all the trig functions used
        Aidan also helped refine the VectorCalculatorUI by adding the directionality button and making sure the 
        arguments could be typed in instead of just being button presses 
        
        Self-grades for 10/23 are below:
        Aidan:
                This week I engaged in my assignment by spending LOTS of time refining the VectorCalculatorUI
                and building the trig functions in VectorCreate. I put lots of effort into analyzing Andrew Hale's 
                base VectorCalculatorUI code and fixing it to allow typing the values of components in, especially
                since our knowledge of buttons and text fields is very limited and we could really benefit from 
                a lecture on listeners and button listeners. This took me hours and there are STILL bugs to mull over 
                but I laid the groundwork to ensure its success. I deserve a 5/5 for working hard in communication and keeping 
                the team on track while also working on the project itself.  
                
                
        Andrew Joseph:     
                During this week I focused on my graphing calculator and while it doesn’t work I feel that I was able to get a decent portion 
                of it done. I mainly focused on making sure that the “points”, which I will eventually use to create the graph, are calculated
                 correctly. To do this I created two classes: Point and Separator. Point is a simple class as it acts as a setter that runs the calculate 
                 method to calculate y through a recognizable format. It is the job of separator to make it recognizable, and it does so by iterating through
                  the input and separating out the numbers and operators into arrays. These arrays are returned and used to calculate y, though like I previously 
                  said it isn’t perfect yet. I plan to clean up the code, add an order of operations, and work on the UI next week. 