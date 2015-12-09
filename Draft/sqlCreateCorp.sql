CREATE DATABASE Corp;
USE Corp;

CREATE USER 'prog'@'localhost' IDENTIFIED BY 'prog';
GRANT ALL ON Corp.* TO 'prog'@'localhost';

DROP TABLE users;
DROP TABLE internships;
DROP TABLE candidates;

-- `date` DATETIME NOT NULL,
-- FOREIGN KEY (email_visiteur) REFERENCES utilisateurs(email)

CREATE TABLE `users` (
`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
`login` VARCHAR(20) NOT NULL,
`password` VARCHAR(20) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE `internships` (
`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
`post_date` DATE NOT NULL,
`salary` INT NOT NULL,
`title` VARCHAR(100) NOT NULL,
`description` VARCHAR(500) NOT NULL,
`person_in_charge` VARCHAR(20) NOT NULL,
`phone_number` VARCHAR(10) NOT NULL,
`selected_candidate` VARCHAR(30),
`provided` BOOL NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE `candidates` (
`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
`student_uuid` VARCHAR(30) NOT NULL,
`internship_id` INT UNSIGNED NOT NULL,
PRIMARY KEY (`id`),
FOREIGN KEY (`internship_id`) REFERENCES internships(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

INSERT INTO users (`login`,`password`) VALUES 
("corp1","corp1"), 
("corp2","corp2");

INSERT INTO internships(`post_date`,`salary`,`title`,`description`,`person_in_charge`,`phone_number`,`selected_candidate`,`provided`) VALUES
('2015-09-15',1100,
"Caractérisation temps réel d’un démonstrateur «Time-Triggered Ethernet» et ARINC653",
"Airbus Defence and Space (Toulouse) recherche un(e) stagiaire (h/f) pour une durée de 6 mois.
Le « Time-Triggered Ethernet » (TTE) est une technologie réseau qui utilise un séquencement temporel pour fournir des communications déterministes temps-réel sur l'Ethernet. Le TTE permet l'utilisation de 3 types de trafic (Time-Triggered, Rate Constrained, équivalent à l'AFDX, et « Best Effort »), une grande précision de datation des données, la synchronisation du réseau par une source temporel interne/externe, etc.",
"Didier Pirou",0561615234,NULL,false),
('2015-10-12',800,"Cloud management (H/F) Toulouse",
"S'intégrer avec nos outils et notre environnement
Définir des profils pour nos applicatifs
Faciliter le déploiement de N versions d'une application en parallèle pour tester de nouvelles versions
Faciliter les livraisons continues, si possible de type « Zero downtime »
Réagir automatiquement ou dans un court délai de temps à des pics de charges",
"Clemence Athee-Na",05615996713,NULL,false);

INSERT INTO candidates(`student_uuid`,`internship_id`) VALUES
("12345678901234567890",1),
("12345678901234567890",2),
("16743849102903030754",1),
("56730982617254689012",1),
("67283910044239655473",1);

SELECT * FROM users;
SELECT * FROM internships;
SELECT * FROM candidates;

-- INSERT INTO visites(`email_visiteur`,`date`) VALUES
-- ("adminuser@test.com",NOW());