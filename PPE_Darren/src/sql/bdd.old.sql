/* 
	SCRIPT BDD CLIENT LEGER / CLIENT LOURD

*/


drop database if exists mairiev;
create database mairiev;
use mairiev;


create table typepresta(
	codetypepresta int not null auto_increment, 
	nomtypepresta varchar(40),
	primary key (codetypepresta)

);


create table prestation( 
	codepresta int not null auto_increment,
	libellepresta varchar(50),
	nombreplaces char(5),
	datepresta date,
 	heurepresta time,
	codetypepresta int,
	primary key (codepresta),
	foreign key (codetypepresta) references typepresta(codetypepresta)
	on delete cascade
    on update cascade
);


create table typeevent(
	codetypeevent int not null auto_increment,
	nomtypeevent varchar(50),
	primary key(codetypeevent)
);


create table evenement(
	codeevent int not null auto_increment,
	nomevent varchar(30),
	tailleevent char(5),
	lieuevent varchar(35),
	dateevent date,
 	heureevent time,
 	codetypeevent int,
	primary key (codeevent),
	foreign key (codetypeevent) references typeevent(codetypeevent)
	on delete cascade
    on update cascade
);

create table famille(
	idfamille int not null auto_increment,
	nom varchar(30),
	prenom varchar(30),
	adresse varchar(100),
	ville varchar(50),
	email varchar(80),
	telephone varchar(10),
	revenuimposable char(7),
	nombreenfants varchar(3),
	dateinscription date,
	sexe enum("homme","femme"),
	tuteur varchar(20),
	primary key (idfamille)
);



create table enfant(
	codef int not null ,
	codeenf int not null ,
	nomenf varchar(20),
	prenomenf varchar(20),
	datenaissaenf date,
	primary key (codef,codeenf)
);

create table employe(

	codeemp int not null auto_increment,
	nom varchar(50) not null,
	prenom varchar(50) not null,
	email varchar(255) not null,
	mdp varchar(255) not null,
	primary key(codeemp)
);


create table user (
	iduser int(3) not null auto_increment, 
	nom varchar (30), 
	prenom varchar(30), 
	email varchar(100), 
	mdp varchar(255), 
	role enum ("admin", "user"), 
	primary key(iduser)
); 

create table userppe (
	iduser int(3) not null auto_increment,
	nom varchar(50),
	prenom varchar(50),
	email varchar(50),
	mdp varchar(255),
	role enum("admin","user"),
	primary key(iduser)
);




/*alter table user 
add CONSTRAINT role enum("admin","user") default user; */


/*------------------INSERTION---------------------*/





	insert into famille values(null,'RICHARD','Vincent','2 rue de Paris','Paris','richard@hotmail.fr',
	'0102030405','1500','2','2021-09-15','homme','Pere');

	insert into famille values(null,'GAUTHIER','Hugo','2 rue de la Défense','Paris','hugo@hotmail.fr',
	'0102030405','1500','2','2021-09-15','homme','pere');

	insert into famille values(null,'Dominique','Mathieu','2 rue de Marseille','Paris','mathieu@hotmail.fr',
	'0102030405','1500','2','2021-09-15','homme','pere');


	insert into typepresta values(null,'Centre Aere');

	insert into typepresta values(null,'Restauration');

	insert into typepresta values(null,'Garderie');



	insert into inscription values(null,'ROGER','Michael','mr@hotmail.fr','123','');

	insert into inscription values(null,'BRUN','Thomas','bt@hotmail.fr','123','');

	insert into inscription values(null,'BLOND','Marie','bm@hotmail.fr','123','');


	insert into typepresta values(null,'Garderie');

	insert into typepresta values(null,'Etude');

	insert into typepresta values(null,'Piscine');

	insert into typepresta values(null,'Revision');



	insert into prestation values(null,'Garderie enfant','10','2022/04/20','17:00','1');

	insert into prestation values(null,'Recolte nourriture','50','2022/01/15','15:00','2');

	insert into prestation values(null,'Acommpagner enfant','50','2022/01/23','12:00','3');


	insert into typeevent values(null,'Concert');

	insert into typeevent values(null,'Gala');

	insert into typeevent values(null,'Spectacle');

	insert into typeevent values(null,'Recolte Argent');


	insert into evenement values(null,'Concert Charite','150','Paris','2022/01/15','15:00','1');

	insert into evenement values(null,'Gala','500','Paris','2022/04/20','19:00','2');

	insert into evenement values(null,'Just Dance','200','Paris','2022/05/12','12:00','3');

	insert into evenement values(null,'Recolte Argent Croix Rouge','1000','Paris VII','2022/01/23','12:00','4');

	

	insert into enfant values(1,1,'Brun','David','2006-09-05');



/*----------------------------------------VUES---------------------------------------*/


create view vEvenement 
	as select nomevent, nomtypeevent  
	from evenement e, typeevent t
	where t.codetypeevent = e.codetypeevent;

create view vPrestation
	as select nomtypepresta, libellepresta, sum(nombreplaces)
	from prestation p, typepresta t
	where p.codetypepresta = t.codetypepresta;

	create view typedepresta as(
	select t.codetypepresta,p.libellepresta, p.nombreplaces
     from prestation p, typepresta t
     where t.codetypepresta = p.codetypepresta);




/*----------------------------------------TRIGGERS---------------------------------------*/

drop trigger if exists gestiondateinscription;
delimiter //
create trigger gestiondateinscription
    before insert on famille
    for each row 
    begin
        if new.dateinscription > curdate() or new.dateinscription is null
            then 
                set new.dateinscription=curdate();
        end if ;
    end //
    delimiter ;




	DROP FUNCTION IF EXISTS email_existe ;  /* créé un compteur qui compte le nombre d'occurence d'un email */
	DELIMITER //
	CREATE FUNCTION email_existe (newemail VARCHAR(50))
	 RETURNS INT
	BEGIN
	 /*declare result int;*/
	    SELECT count(*) FROM user WHERE email = newemail INTO @result;
	    RETURN @result;
	END//
	DELIMITER ;
	insert into user values(null,'chouaki','iris') ,
	                        (null,'Jessy','attention');
	SELECT email_existe('chouaki');


	DROP TRIGGER IF EXISTS valide_insertion;  /* Trigger qui permet de vérifier si l'email est déjà contenu dans la base. */
DELIMITER //
CREATE TRIGGER valide_insertion 
BEFORE INSERT ON userppe 
FOR EACH ROW
BEGIN
    THEN
        signal sqlstate'45000'
        set message_text='impossible';   
    END IF;	
END //
DELIMITER ;

/* créer trigger qui permet d'archiver tous les evènements quand ils sont finis. Les supprimer de evenement, puis 
les déplacer dans la table d'archivage*/

delimiter //
create trigger modifierMdp 
	before insert on userppe 
	for each row 
	begin 
		set new.mdp = sha1(new.mdp);
	end //
delimiter ;

delimiter //
create trigger modifierMdp2 
	before update on userppe 
	for each row 
	begin 
		set new.mdp = sha1(new.mdp);
	end //
delimiter ;




/*------------------INSERTION---------------------*/
	
	
	insert into user values(null,'aghouiles','darren','d@hotmail.fr','123','admin');

	insert into user values(null,'Mbitcha','eddy','e@hotmail.fr','123','user');

	insert into userppe values(null, "Yacine","Eddy","a@hotmail.fr","123","admin");

