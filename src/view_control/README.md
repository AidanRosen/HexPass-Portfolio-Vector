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
