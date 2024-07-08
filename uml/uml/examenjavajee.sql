/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de cr�ation :  07/07/2024 18:38:13                      */
/*==============================================================*/


drop table if exists ADHERENT;

drop table if exists BIBLIOTHECAIRE;

drop table if exists BIBLIOTHEQUE;

drop table if exists DICTIONNAIRE;

drop table if exists EMPRUNT;

drop table if exists MANUEL;

drop table if exists REVUE;

drop table if exists ROMAN;

/*==============================================================*/
/* Table : ADHERENT                                             */
/*==============================================================*/
create table ADHERENT
(
   ID_ADHERENT          int not null,
   ID_PRET              int not null,
   EMAILETUDIANT        char(254) not null,
   NUMEROCARTEETUDIANT  varchar(254) not null,
   primary key (ID_ADHERENT)
);

/*==============================================================*/
/* Table : BIBLIOTHECAIRE                                       */
/*==============================================================*/
create table BIBLIOTHECAIRE
(
   ID_BIBLIOTHECAIRE    int not null,
   NOM                  char(25),
   PRENOM               char(25),
   EMAIL                varchar(254),
   TELEPHONE            varchar(254),
   primary key (ID_BIBLIOTHECAIRE)
);

/*==============================================================*/
/* Table : BIBLIOTHEQUE                                         */
/*==============================================================*/
create table BIBLIOTHEQUE
(
   ID_BIBLIOTHEQUE      int not null,
   ID_PRET              int not null,
   ID_BIBLIOTHECAIRE    int not null,
   ID_DOCUMENT          int not null,
   NOMBU                char(25),
   EMAILBU              char(254),
   primary key (ID_BIBLIOTHEQUE)
);

/*==============================================================*/
/* Table : DICTIONNAIRE                                         */
/*==============================================================*/
create table DICTIONNAIRE
(
   ID_DOCUMENT          int not null,
   TYPE_DOCUMENT        char(25) not null,
   NUMENREG             int,
   TITRE                char(25),
   LANGUE               char(25),
   primary key (ID_DOCUMENT)
);

/*==============================================================*/
/* Table : EMPRUNT                                              */
/*==============================================================*/
create table EMPRUNT
(
   ID_PRET              int not null,
   ID_BIBLIOTHECAIRE    int,
   ID_DOCUMENT          int,
   DATEDEBUTPRET        date,
   DATEFINPRET          date,
   DUREEEMPRUNT         int,
   PENALITES            decimal(25),
   primary key (ID_PRET)
);

/*==============================================================*/
/* Table : MANUEL                                               */
/*==============================================================*/
create table MANUEL
(
   ID_DOCUMENT          int not null,
   TYPE_DOCUMENT        char(25) not null,
   NUMENREG             int,
   TITRE                char(25),
   TYPE_LIVRE           char(25) not null,
   AUTRE                int,
   NBRPAGES             int,
   DOMAINE              char(10) not null,
   primary key (ID_DOCUMENT)
);

/*==============================================================*/
/* Table : REVUE                                                */
/*==============================================================*/
create table REVUE
(
   ID_DOCUMENT          int not null,
   TYPE_DOCUMENT        char(25) not null,
   NUMENREG             int,
   TITRE                char(25),
   MOIS                 int,
   ANNEE                int,
   primary key (ID_DOCUMENT)
);

/*==============================================================*/
/* Table : ROMAN                                                */
/*==============================================================*/
create table ROMAN
(
   ID_DOCUMENT          int not null,
   TYPE_DOCUMENT        char(25) not null,
   NUMENREG             int,
   TITRE                char(25),
   TYPE_LIVRE           char(25) not null,
   AUTRE                int,
   NBRPAGES             int,
   GENRE                char(10) not null,
   primary key (ID_DOCUMENT)
);

alter table ADHERENT add constraint FK_EMPRUNTPAR foreign key (ID_PRET)
      references EMPRUNT (ID_PRET) on delete restrict on update restrict;

alter table BIBLIOTHEQUE add constraint FK_CONTIENTDOCUMENT foreign key (ID_DOCUMENT)
      references ROMAN (ID_DOCUMENT) on delete restrict on update restrict;

alter table BIBLIOTHEQUE add constraint FK_CONTIENTDOCUMENT2 foreign key (ID_DOCUMENT)
      references REVUE (ID_DOCUMENT) on delete restrict on update restrict;

alter table BIBLIOTHEQUE add constraint FK_CONTIENTDOCUMENT3 foreign key (ID_DOCUMENT)
      references DICTIONNAIRE (ID_DOCUMENT) on delete restrict on update restrict;

alter table BIBLIOTHEQUE add constraint FK_CONTIENTDOCUMENT4 foreign key (ID_DOCUMENT)
      references MANUEL (ID_DOCUMENT) on delete restrict on update restrict;

alter table BIBLIOTHEQUE add constraint FK_EMPLOYEDANS foreign key (ID_BIBLIOTHECAIRE)
      references BIBLIOTHECAIRE (ID_BIBLIOTHECAIRE) on delete restrict on update restrict;

alter table BIBLIOTHEQUE add constraint FK_ENREGISTREEMPRUNT foreign key (ID_PRET)
      references EMPRUNT (ID_PRET) on delete restrict on update restrict;

alter table EMPRUNT add constraint FK_CONCERNEEMPRUNT foreign key (ID_DOCUMENT)
      references ROMAN (ID_DOCUMENT) on delete restrict on update restrict;

alter table EMPRUNT add constraint FK_CONCERNEEMPRUNT2 foreign key (ID_DOCUMENT)
      references REVUE (ID_DOCUMENT) on delete restrict on update restrict;

alter table EMPRUNT add constraint FK_CONCERNEEMPRUNT3 foreign key (ID_DOCUMENT)
      references DICTIONNAIRE (ID_DOCUMENT) on delete restrict on update restrict;

alter table EMPRUNT add constraint FK_CONCERNEEMPRUNT4 foreign key (ID_DOCUMENT)
      references MANUEL (ID_DOCUMENT) on delete restrict on update restrict;

alter table EMPRUNT add constraint FK_TRAITEEMPRUNT foreign key (ID_BIBLIOTHECAIRE)
      references BIBLIOTHECAIRE (ID_BIBLIOTHECAIRE) on delete restrict on update restrict;

