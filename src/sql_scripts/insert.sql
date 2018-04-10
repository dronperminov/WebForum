use webforum;

/* Users */
insert into User values(1, "Perminov", "Andrew", "Igorevich", null, null, '2018-03-1', "dronperminov", "u3Dn2Ssr", 1);
insert into User values(2, "Volodkin", "Vladislav", "Vasilievich", null, null, '2018-04-05', "volodkin", "1q2w3e4r5t", 0);
insert into User values(3, "Petrov", "Oleg", "", null, null, '2018-02-04', "petrov.oleg", "q2sgtyw", 0);
insert into User values(4, "Test", "Test", "Test", null, null, '2017-01-01', "test", "test", 0);
insert into User values(5, "Moderator", "Moderator", "Moderator", null, null, '2017-01-01', "moderator", "moderator", 1);
insert into User values(6, "Bespalova", "Anastasia", "", null, null, '2018-01-20', "anastasia1997", "anasTaSya", 0);
insert into User values(7, "Surname1", "Name1", "Patronymic1", null, null, '2018-02-12', "user1", "pass1", 1);
insert into User values(8, "Surname2", "Name2", "", null, null, '2018-01-05', "user2", "pass2", 0);
insert into User values(9, "Surname3", "Name3", "Patronymic3", null, null, '2018-03-08', "user3", "pass3", 0);
insert into User values(10, "Surname4", "Name4", "", null, null, '2018-04-09', "user4", "pass4", 0);

/* Sections */
insert into sections values(1, 'Programming in C');
insert into sections values(2, 'Programming in C++');
insert into sections values(3, 'Programming in C#');
insert into sections values(4, 'SEO and markiting');
insert into sections values(5, 'Controller programming');
insert into sections values(6, 'Arduino');

/* Topics */
insert into topic values(1, 1, 'Scanf error', 'If i use scanf with %c, i get error in console');
insert into topic values(2, 1, 'Function may be unsafe error', 'Help me');
insert into topic values(3, 1, 'Creating binary tree error', 'Tree is not creating. Only one element.');
insert into topic values(4, 1, 'First C program.', 'How compile it');
insert into topic values(5, 1, 'Developing invironment for good coding', '');

insert into topic values(6, 2, 'Cin and cout not found', 'Where cin and cout in c++ code?');
insert into topic values(7, 2, 'isream and ifstream', 'What am i doing?');
insert into topic values(8, 2, 'Where is thread in windows?', 'Code not compile in Windows 10');

insert into topic values(10, 3, 'Plotter', 'How can i create a plotter in C#?');
insert into topic values(11, 3, '.Net components', 'I don''t see any component in form');
insert into topic values(12, 3, 'Input', 'How to read integer value from console');

insert into topic values(13, 4, 'Instruments for loking position of site', '');
insert into topic values(14, 4, 'Yandex.Webmaster and Google Search Console', 'Hot add www and https versions of my site?');
insert into topic values(15, 4, 'Headers in page. Need?', '');
insert into topic values(16, 4, 'Meta tags description and keyword', 'I don''w want to use it. Google and Yandex go my site down?');

insert into topic values(17, 5, 'ATmega8 ports', 'How switch on PD5 in AVR ATmega8');
insert into topic values(18, 5, 'Could not program my controller on ISP with AVRdude', '');
insert into topic values(19, 5, 'AVRdude error. STK500 not found', '');

insert into topic values(20, 6, 'Hello world', 'My first Arduino "hello world" is not working');
insert into topic values(21, 6, 'Arduino as AVR ATmega328P.', 'How write program for arduino as C program for AVR 328p');

/* Messages */
insert into messages values(1, 1, 1, 'Hello, please, write more of you problem and I try to help you with this.', '2018-02-10', null);