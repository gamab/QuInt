-- CREATE DATABASE AdminINSA;
USE AdminINSA;

-- CREATE USER 'prog'@'localhost' IDENTIFIED BY 'prog';
GRANT ALL ON AdminINSA.* TO 'prog'@'localhost';

-- DROP TABLE Internships;
-- DROP TABLE Agreements;

CREATE TABLE `Agreements`(
`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
`idStudent` VARCHAR(50) NOT NULL,
`idCompany` VARCHAR(50) NOT NULL,
`idPendingInternship` VARCHAR(30) NOT NULL,
`signAdmin` BOOLEAN,
`signStudent` BOOLEAN,
`signCorp` BOOLEAN,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE `Internships`(
`id` INT UNSIGNED NOT NULL AUTO_INCREMENT, 
`candidate` VARCHAR(50) NOT NULL,
`company` VARCHAR(50) NOT NULL,
`postDate` VARCHAR(12) NOT NULL,
`salary` INT UNSIGNED NOT NULL, 
`title` VARCHAR(100) NOT NULL, 
`description` VARCHAR(500) NOT NULL,
`tutor` VARCHAR(50) NOT NULL, 
`phoneNumber` VARCHAR(20) NOT NULL,
`department` VARCHAR(20) NOT NULL, 
`location` VARCHAR(300) NOT NULL,  
`isPending` BOOLEAN,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;


INSERT INTO Agreements(`idStudent`, `idCompany`, `idPendingInternship`, 
`signAdmin`, `signStudent`, `signCorp`) VALUES
("meymandi@etud.insa-toulouse.fr","celad@celad.com","Offre7", TRUE, TRUE, TRUE),
("mabille@etud.insa-toulouse.fr","thales@thales.com","Offre4", FALSE, FALSE, FALSE),
("ghader@etud.insa-toulouse.fr","sogeti@sogeti.fr","Offre2", TRUE, TRUE, TRUE),
("hayou@etud.insa-toulouse.fr","sogeti@sogeti.fr","Offre5", TRUE, TRUE, TRUE),
("tribhout@etud.insa-toulouse.fr","thales@thales.com","Offre3", TRUE, TRUE, TRUE),
("westhead@etud.insa-toulouse.fr","thales@thales.com","Offre1", FALSE, FALSE, FALSE);

INSERT INTO Internships(`candidate`, `company`, `postDate`, `salary`, `title`, 
`description`, `tutor`, `phoneNumber`, `department`, `location`, `isPending`) VALUES
("meymandi@etud.insa-toulouse.fr", "celad@celad.com", "10/10/15", 6000, "Bla", "Ble", "Bli", "01-23-45-67-89",
 "Blo", "Blu", NULL),
("mabille@etud.insa-toulouse.fr","thales@thales.com", "11/11/15", 6000, "Super stage", "Des trucs tout compliques sur un nordi", 
"Mr RESPECTABLE Levieux", "06-38-65-65-65", "Responsable d'atelier", "Pole Nord", NULL);

INSERT INTO Agreements(`idStudent`, `idCompany`, `idPendingInternship`, 
`signAdmin`, `signStudent`, `signCorp`) VALUES
("meymandi@etud.insa-toulouse.fr","celad@celad.com","Offre7", TRUE, TRUE, TRUE),
("mabille@etud.insa-toulouse.fr","thales@thales.com","Offre4", FALSE, FALSE, FALSE),
("ghader@etud.insa-toulouse.fr","sogeti@sogeti.fr","Offre2", TRUE, TRUE, TRUE),
("hayou@etud.insa-toulouse.fr","sogeti@sogeti.fr","Offre5", TRUE, TRUE, TRUE),
("tribhout@etud.insa-toulouse.fr","thales@thales.com","Offre3", TRUE, TRUE, TRUE),
("westhead@etud.insa-toulouse.fr","thales@thales.com","Offre1", FALSE, FALSE, FALSE);

INSERT INTO Internships(`candidate`, `company`, `postDate`, `salary`, `title`, 
`description`, `tutor`, `phoneNumber`, `department`, `location`, `isPending`) VALUES
("meymandi@etud.insa-toulouse.fr", "celad@celad.com", "10/10/15", 6000, "Développeur application web",
 "Vous serez intégré à une équipe de développement pour un grand projet au sein de notre entreprise.
Vous participerez à toute la phase de conception et de tests...", "M. Georges JO", "01-23-45-67-89",
 "Blo", "Blu", NULL),
("mabille@etud.insa-toulouse.fr", "celad@celad.com", "10/10/15", 5500, "Enseignant-chercheur au LAAS",
 "Vous serez intégré à une équipe de recherche pour un grand projet au sein de notre entreprise.
Vous participerez à toute la phase de conception et de tests...", "M. Georges JO", "01-23-45-67-89",
 "Blo", "Blu", NULL),
("westhead@etud.insa-toulouse.fr", "sogeti@sogeti.com", "10/10/15", 6000, "Développeur application Python",
 "Vous serez intégré à une équipe de développement pour un grand projet au sein de notre entreprise.
Vous participerez à toute la phase de conception et de tests...", "M. Georges JO", "01-23-45-67-89",
 "Blo", "Blu", NULL);


SELECT * FROM Agreements;

SELECT * FROM Internships;
