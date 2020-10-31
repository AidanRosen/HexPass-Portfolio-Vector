# How to Run VectorCalculatorUI:

    1.Upon running the application, click at the top right of the menu on "VectorCalculator". A new window will open with the 

    2.After entering the calculator, you will see two blue squares. Click on them and type a number into each. 

    3.After typing into both boxes, press the blue bottom on the lower right. '
    
    4.After clicking the blue button in the lower right, A new window will open BEHIND the vectorCalculator. Please move vectorCalculator to see it.
    This window contains a drawn rectangle representing the magnitude of the vector calculated in the calculator.
    
    5.End the program by exiting all windows and pressing stop

NOTE: please be realistic with values because this vector calculator also creates a calculator measured in pixels,
so please use an appropriate number of pixels! (I.e don't type in "5", because that is too small to see, or "2000", because that is too large)
<br /> <br />
 

NOTES and future work: 
    Add an arrow head to the drawn vector
    Cause the drawn vector to rotate according to the angle input into the calculator
    Add old terminal project to portfolio

# How to Run Graphing Calculator:

    1. Choose a graphing option from the main menu. 
    
    2. A new window will pop up that will need user input. If you fail to input a valid value (eg. you put in text instead of a number), the program will restart.
    
    3. When you are finished inputting the equation, click "Graph" or follow the instructions to create the graph.
    
    4. A graph of the function will be displayed in a new window. 
    
    5. You may still go back to the second window to edit your inputs to create a new graph, or back to the first window to choose a different type of graph.
        *Smoothness refers to the horizontal distance between each coordinate that is shown in the graph. Smaller values mean a more connected line.
        *Magintude refers to what each coordinate represents; eg. if you put in a magnitude of 10 for y-axis, the y-axis will be "zoomed out" by 10 times and each row in the 
        display will represent a value of 10.

 <br /> <br /> <br />

# %%%%%%Links to Code + Goals Met

NOTE: Scrum Master Grades are marked with a ***
<br /> 
NOTE: Pair/Trio grades are marked with a !!!

# Aidan:
   
Here is the link to my menu code, and the whole file is linked because I built it all: https://github.com/AidanRosen/HexPass-Portfolio-Vector-IDEA/blob/master/src/centralMenu.java 

    One of our goals this week was to build a JFrame menu (in our project plan, not the Slack message sent). This was completed and done with both menu buttons and menuItem buttons 
        
Here is the link to my JFrame draw code, whole file linked because I built it all: https://github.com/AidanRosen/HexPass-Portfolio-Vector-IDEA/blob/master/src/vector_calc/VectorDraw.java
    
    Another goal was to actually render a shape based on the calculated magnitude. This was achieved with the above code. 
        
Here is the link to the line where the bug about having to press enter twice was fixed: https://github.com/AidanRosen/HexPass-Portfolio-Vector-IDEA/blob/a75d771e4fb7696ac2c3416842405e865760e910/src/vector_calc/VectorCalculatorUI.java#L224
    
    By changing the "SaveValueArg1" and "SaveValueArg2"calls from being after typing to just when the button to calculate the vector is pressed, the bug was fixed.
    Notice how it says only "saveValueOfArg1(textField_vert);" and "saveValueOfArg1(textField_horiz);" only within this listener. That's how the bug was fixed     

***Grade: 5/5. Worked hard with keeping everyone on track, goals set. Worked hard individually on menu code and drawing code 

# Alex: 

Here is the link to the graphing calculator section of the portfolio project that I worked on: https://github.com/AidanRosen/HexPass-Portfolio-Vector-IDEA/tree/master/src/Graphing_Calculator

Some of our goals this week included completeing the UI, figuring out how to create a new JFrame window post-frame creation, and create new graph options.

    I completed the UI for the main menu of the graphing calculator.
    
    I also figured out how to create more JFrames: create a new class extending JFrame, and call that class' contructor which will automatically call JFrame's constructor as well and create a new JFrame. This was implemented in the Graphing Calculator UI file which creates a new Frame to display the graph.
    
    Although we did not get around to creating a new graph option, I was able to convert the code to mvc format. I also worked on creating logic guidelines for Atharva as he has never done Java before this class and I think it should be more important for him to practice writing code right now rather than figuring out logic and program flow.
    

***Grade: 5/5. Converted to MVC format which is impressive since we didn't have BlueJ. 

# Atharva:

Link to what I worked on: https://github.com/AlexH04/Calculator2-MVC--Alex-Atharva/blob/main/mvc-idea/src/view_control/CalculatorTextUI.java and https://github.com/athkud123/HexPass-Portfolio-Vector/blob/master/src/Graphing_Calculator/GraphPoly.java

This week I met my goals by working with Alex to finalize the text-based UI and we also began focusing on GraphPoly code within our graphing calculator. I started to become more familliar with Github, IntelliJ, and JFrame after having more experience with them; I still have stuff to learn, but my work has become more efficient from last week.

Since I am less experienced, Alex was able to help me with both the UI and making more graphing options by making a framework of logic for me to go off of. I took heed of this logic and understood what my code was doing.

***Grade: 4.5/5 Didn't talk very much during meetings so I don't know how he collaborated with Alex, but he seemingly accomplished a lot. 



# Andrew Joseph

***Grade:

# Andrew Hale:

Here is the link to the VectorCalculatorUI code. I am linking the entire .java file because I created it: https://github.com/AidanRosen/HexPass-Portfolio-Vector-IDEA/blob/master/src/vector_calc/VectorCalculatorUI.java

The first goal I met this week was cleaning up the menu and fixing bugs.
    
    Achived this by adding labels in order for the user experience to be more obvious on what you are inputting. Before, when the user clicked on the text-box, the title for it dissapeared. By using a label above, the user clearly knows which value they are inputting.
    
Here is the link to the first of 8 lines where the Horizontal label is created: https://github.com/AidanRosen/HexPass-Portfolio-Vector-IDEA/blob/master/src/vector_calc/VectorCalculatorUI.java#L134

Here is the link to the first of 8 lines where the Vertical label is created: https://github.com/AidanRosen/HexPass-Portfolio-Vector-IDEA/blob/master/src/vector_calc/VectorCalculatorUI.java#L176  

    I also fixed the 0/0 issue when the "Create" button was pressed. I did this by creating an inital number already inputted into the system for both the Horizontal and Vertical component.
    
Here is the link to the line where I fixed this issue for the horizontal component: https://github.com/AidanRosen/HexPass-Portfolio-Vector-IDEA/blob/master/src/vector_calc/VectorCalculatorUI.java#L159

Here is the link to the line where I fixed this issue for the vertical component: https://github.com/AidanRosen/HexPass-Portfolio-Vector-IDEA/blob/master/src/vector_calc/VectorCalculatorUI.java#L198
    
    Throughout all this I fixed the spacing and overlapping buttons on the VectorCalculatorUI.
    
Another one of my goals was to create a vector line. We technically met this goal.

     Althought we said only magnitude, we were determined to make a correct vector line. Aidan worked very hard on creating this line but I didn't get the time to create the arrow at the end of it. I am dissapointed that I could not achieve this goal.
     
 ***Grade: 5/5 Always wanted to work, even when his assignment was done. Contributed well to the vector files 
 
 # Aidan, Andrew Hale, Andrew Joseph 
 !!! 19/20 I didn't get to all the goals, namely drawing a vector with an arrowhead. However, Andrew and I worked extensively on the vector code and learned a lot about creating new JFrame elements (Andrew Hale learned more about adding text and polygon drawing) while I worked really hard on drawing rectangles and learning a lot about imported graphics. Much of our learning went into the journal, including Andrew Josephs. Andrew Joseph definitely contributed to keeeping on track, adding what he was working on to the journal, and producing content for the main project. 
 
 # Alex, Atharva
 19/20. We did a good job on working on the graphing calculator, but I feel like we could have shifted our priorities and made the framework first right after converting to mvc instead of first reworking the ui; as this would give Atharva more time to work on his part.

 <br /> <br />
# ##########Links to Journals################

Aidan, Andrew Hale, Andrew Joseph: https://docs.google.com/document/d/1tpO2c3qkdsvuKmP1z2kaieqsh3c0ZXMnNC4YMyD1iuk/edit?usp=sharing

Atharva, Alex: https://docs.google.com/document/d/10XEXkkcqk-_1BDuC3DMJvTe5CAeD7eNABT_isg3faxM/edit?usp=sharing


 <br /> <br /> <br /> <br />
+++++++++++++++++++++++++++++++++++++++++

# OLD, week of 10/19 

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
                
        Andrew Hale:
                This week I learne how to use InteliJ, GitHub, and JFrame. I had a lot of prooblems in setting up Intelij
                many of my files either wern't installed or in the wrong place. My scrum team really helped me out in fixing
                these issues. They helped me get the correct SDK installed and also fix the issue with building the program.
                I also learned how to push, pull, and commit with Git using InteliJ. The knowlage from last year's Computer
                Scieince class definently helped me and I was able to help out other memebers of my scrum group who wern't
                as familiar with GitHub. Lastly, I mainly worked on learning Java and JFrame. This week started out with
                me using your calculator in order to learn how to edit JFrame buttons but by the end of the week I added
                text fields. This included adding a new import and adding a new JFrame type. I believe I deserve a 5/5
                this week becaouse of the amount of time I spent fixing issues with the program and working on our new
                projects layout.
                
                
        
IMPORTANT NOTE: This doesn't work yet, the calculation is still
being finalized, and many more bugfixes and optimizations
will be needed before functional. I plan to do these this coming week.

UI will be set up after this, though I already have a plan in mind
so it should not take much time.

FUNCTIONALITY
-------------

How the graphing calculator works:
type in your input using basic math functions (plus, minus, multiply, divide, squareroot, squared, 
more in the future) and click "calculate" which will 
generate points for a graph, then will graph it.


JUSTIFICATION
-------------

During this week I focused on my graphing 
calculator and, while isn't functional yet, 
I feel that  I was able to get a decent portion of it
done. I mainly focused on making sure that the 
“points”, which I will eventually use to create the
graph, are calculated correctly. To do this I created 
two classes: Point and Separator. Point is a simple 
class as it acts as a setter that runs the calculate
method to calculate y through a recognizable format. 
It is the job of separator to make it recognizable, 
and it does so by iterating through the input and 
separating out the numbers and operators into arrays. 
These arrays are returned and used to calculate y, 
though like I previously said it isn’t perfect yet.
I plan to clean up the code, add an order of operations, 
and work on the UI next week. 

GRADING
-------

Overall I think I should get a 4/5 on this because 
the project isn't complete and I didn't meet my goals
for the week, however I was off from my goal by only
a few bugs. Since the majority of this goal is complete
and only needs to be cleaned up and bugfixed, errors
that I feel are more minor than major, 1 point seems
like an appropriate deduction for these slight mistakes.


Readme Justifications (Week 7) for Alex and Atharva:

Alex-this week I worked on making a main menu for the graphing calculator part of the main project. I also worked on splitting Mr. M's calculator code into mvc for Calculator 2, and I guided Atharva to make a text-based Calculator UI for Calculator 2 (link to calculator 2: https://github.com/AlexH04/Calculator2-MVC--Alex-Atharva). Next ween I plan to organize the main project as mvc now that I have more experience with how it works.
  Individual block of code: src/Graphing_Calculator/GraphCubic was imported from the previous calculator project and src/Graphing_Calculator/GraphMain was coded my me this week.
  Self-grade: 4/5. I could have paid more attention to the calculator 2 minilab instead of pushing it to the end of the week; but I think I did a good job for the main portfolio assignment.
 
Atharva- This week I worked on making the text based UI for the calculator and Alex guided me on how to do so, since I have little experience with coding. Next week, I plan to contribute more to our portfolio and communicate strongly both in and out of the classroom (by using Zoom when necessary).
Individual block of code: Calculator2-MVC--Alex-Atharva/mvc-idea/src/view_control/CalculatorTextUI.java 
Self-grade: 4/5 because I could have probably communicated better this week and checked slack on a regular basis; I would only check after long periods of time, which made communication slightly harder for my teammates. I will make sure to improve on this for next week.

