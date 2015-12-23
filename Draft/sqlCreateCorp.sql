CREATE DATABASE Corp;
USE Corp;

CREATE USER 'prog'@'localhost' IDENTIFIED BY 'prog';
GRANT ALL ON Corp.* TO 'prog'@'localhost';

DROP TABLE candidates;
DROP TABLE internships;

-- `date` DATETIME NOT NULL,
-- FOREIGN KEY (email_visiteur) REFERENCES utilisateurs(email)


CREATE TABLE `internships` (
`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
`post_date` DATE NOT NULL,
`salary` INT NOT NULL,
`title` VARCHAR(100) NOT NULL,
`description` VARCHAR(500) NOT NULL,
`person_in_charge` VARCHAR(20) NOT NULL,
`phone_number` VARCHAR(11) NOT NULL,
`department` VARCHAR(4) NOT NULL,
`selected_candidate` VARCHAR(30),
`provided` BOOL NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE `candidates` (
`student_uuid` VARCHAR(30) NOT NULL,
`internship_id` INT UNSIGNED NOT NULL,
PRIMARY KEY (`student_uuid`,`internship_id`),
FOREIGN KEY (`internship_id`) REFERENCES internships(`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1;


INSERT INTO internships(`post_date`,`salary`,`title`,`description`,`person_in_charge`,`phone_number`,`department`,`selected_candidate`,`provided`) VALUES
('2015-09-15',1100,
"Caractérisation temps réel d’un démonstrateur «Time-Triggered Ethernet» et ARINC653",
"Airbus Defence and Space (Toulouse) recherche un(e) stagiaire (h/f) pour une durée de 6 mois.
Le « Time-Triggered Ethernet » (TTE) est une technologie réseau qui utilise un séquencement temporel pour fournir des communications déterministes temps-réel sur l'Ethernet. Le TTE permet l'utilisation de 3 types de trafic (Time-Triggered, Rate Constrained, équivalent à l'AFDX, et « Best Effort »), une grande précision de datation des données, la synchronisation du réseau par une source temporel interne/externe, etc.",
"Didier Pirou","0561615234","GEI",NULL,false),
('2015-10-12',800,"Cloud management (H/F) Toulouse",
"S'intégrer avec nos outils et notre environnement
Définir des profils pour nos applicatifs
Faciliter le déploiement de N versions d'une application en parallèle pour tester de nouvelles versions
Faciliter les livraisons continues, si possible de type « Zero downtime »
Réagir automatiquement ou dans un court délai de temps à des pics de charges",
"Clemence Athee-Na","0561599671","GEI",NULL,false);

INSERT INTO candidates(`student_uuid`,`internship_id`) VALUES
("mabille@etud.insa-toulouse.fr",1),
("mabille@etud.insa-toulouse.fr",2),
("meymandi@etud.insa-toulouse.fr",1),
("hayou@etud.insa-toulouse.fr",1),
("ghader@etud.insa-toulouse.fr",1);

SELECT * FROM internships;
SELECT * FROM candidates;

-- INSERT INTO visites(`email_visiteur`,`date`) VALUES
-- ("adminuser@test.com",NOW());