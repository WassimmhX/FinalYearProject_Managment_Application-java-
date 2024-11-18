create type intTable as table of int;
create type CINTABLE as table of varchar(8);
create table Enseignant(CIN varchar(8) ,fullName varchar(40),age integer,
                        specialite varchar(20),encadre intTable) nested table encadre store as nGroup;
create table Etudiant(CIN varchar(8) ,fullName varchar(40),age integer,
                      formation varchar(10));
create table Groups(nbGroup integer ,etudiants CINTABLE,
                    encadreur varchar(30)) nested table etudiants store as GROUPETD ;
create table PFE(name varchar(30) , nbgroup integer ,encadreur varchar(8) );
create table Soutenance(date_ DATE ,heure integer ,locale varchar(15) ,
                        president varchar(8) ,rapporteur varchar(8) ,examinateur varchar(8),
                        encadreurs CINTABLE,nbGroup integer,PFENAME varchar(30),
                        passee varchar(15),note real) nested table encadreurs store as CINENCADREURS;
alter table ENSEIGNANT add constraint prKEns primary key (CIN);
alter table Etudiant add constraint prKEtd primary key (CIN);
alter table GROUPS add constraint prKGrp primary key (nbGroup);
alter table GROUPS add constraint frKGrp foreign key (encadreur) references ENSEIGNANT(CIN) on delete cascade ;
alter table PFE add constraint prKPfe primary key (NAME) ;
alter table PFE add constraint frKPfe1 foreign key (nbgroup) references GROUPS(nbGroup)on delete cascade;
alter table PFE add constraint frKPfe2 foreign key (encadreur) references ENSEIGNANT(CIN) on delete cascade;
alter table SOUTENANCE add constraint prKStn primary key (date_,heure,locale);
alter table SOUTENANCE add constraint frKStn1 foreign key (president) references ENSEIGNANT(CIN)on delete cascade;
alter table SOUTENANCE add constraint frKStn2 foreign key (rapporteur) references ENSEIGNANT(CIN)on delete cascade;
alter table SOUTENANCE add constraint frKStn3 foreign key (examinateur) references ENSEIGNANT(CIN)on delete cascade;
alter table SOUTENANCE add constraint frKStn4 foreign key (nbGroup) references GROUPS(nbGroup)on delete cascade;
alter table Soutenance add constraint frKStn5 foreign key (PFENAME) references PFE(name) on delete cascade;
delete from Enseignant where CIN not in 'g'