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
- ChatGPT on a variety of topics, from incorrect syntax to (some) error handling.

> I want to add that there's a problem that i wouldn't have found had it not been for my friend, Inno.

==================================================================================================

Ini merupakan laporan untuk tugas ini, oleh Mifey05

Satu bagian yang memakan 60% waktu pembuatan code ini hanya pada error handling. Itu tidak semudah
> taruh semua di dalam try and catch dan berdoalah

Yah, memang saya menggunakan cukup banyak (Setidaknya 12 kali), itu semua hanya safety net, apabila muncul error yang memang tidak bisa di handle oleh code.
Program ini berisikan sekitar 351 baris kode.

Saya menggunakan Visual Studio Code untuk membuat program ini.
Code nya dimulai dengan pembuatan metode untuk setiap fungsi dari task manager ini. Kemudian dilanjutkan dengan initialisasi berbagai data, lalu memanfaatkan "while (true)" loop untuk terus menjalankan program ini sampai user memilih untuk exit. Program ini kemudian memanfaatkan switch-case untuk efisiensi, setiap case memanggil metode masing-masing.

Untuk masalah? well, mulai dari mana?
Sebelum itu, saya mau bilang bahwa saya berterimakasih banyak ke ChatGPT untuk ini.
- Saya tidak bisa menemukan beberapa syntax spesifik, untuk itu ChatGPT membantu ini.
- "break" di dalam case yang berada di dalam "while (true)" loop tidak keluar dari loop, hanya casenya saja. ChatGPT memberikan solusi dengan memberi label kepada loop agar terdapat point of reference untuk lompatan "break".
- Stack undo berbagian dengan kedua array dan linked list. Saya mencoba bertanya ke ChatGPT, tetapi ujungnya saya selesaikan dengan menggunakan boolean untuk membedakan apakah data itu dari array atau linked list.
- Masalah di code seperti Syntax salah diselesaikan dengan mengecek GeeksForGeeks atau bertanya ke ChatGPT.
- Banyak masalah yang berhubungan dengan error handling seperti "menghapus dynamic task" yang desync dengan data yang mengikuti itu harus diurus. sekali lagi, dengan bertanya ke ChatGPT.
TL;DR, 4/5 nya saya tahu konsep atau logikanya, hanya tidak tahu syntax nya. Sisanya, hanya ketika saya memang tidak tahu bagaimana.

credits:
- Reading material dari eLearn.
- GeeksforGeeks dalam Java Array, Stack, Linked List, dan Java Exception (try and catch).
- w3schools on ANSI colors.
- ChatGPT dalam berbagai topik, dari kesalahan syntax sampai ke (beberapa) error handling.

> Saya mau menambahkan bahwa terdapat kesalahan yang saya tidak temukan sebelumnya kalau bukan karena temanku, Inno.
