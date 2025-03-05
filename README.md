This is the report for this assignment, made by Mifey05

The one part that consumes 60% of my time is the error handling. it's not just a simple
> put everything in a try and catch and hope for the best

although i do use a lot of it in my code (at least 12 instances), it's all just a safety net in case of errors that my code can't handle.
The program has around 351 lines of code.

I use Visual Studio Code to code this.
The code begins with the methods for each functions of the manager. then continuing with initialization of data, then uses a while (true) piece to keep the program running until the user decide to exit. The program then utilizes a switch-case for more efficiency, each case calling its respective method.

As for problems? woowee, where do i begin?
Before that, i'd like to say that i owe ChatGPT a lot for this.
- I can't find several specific syntaxes, for which ChatGPT helped me.
- "break" inside of a case that's within a while (true) loop doesn't exit the loop, just the case. ChatGPT provided the solution of labeling the loop for the "break" to jump to.
- The undo stack shares both array and linked list. I tried getting help from ChatGPT but i eventually resolved it by using boolean to differentiate between either one.
- Code problems such as incorrect syntax resolved via checking GeeksForGeeks or asking ChatGPT.
- Lots of issues involving error handling such as the "deleting dynamic task" part that desyncs data that tracks it had to be dealt with. again, via asking ChatGPT.
To summarize, 4/5 of the time, i'd know the concept/logic and not the syntax, the rest is when i really don't know what or how.

credits:
- Reading material from eLearn.
- GeeksforGeeks on Java's Array, Stack, Linked List, and Java Exception (try and catch).
- w3schools on ANSI colors.
- ChatGPT on a variety of topics, from syntax to (some) error handling.