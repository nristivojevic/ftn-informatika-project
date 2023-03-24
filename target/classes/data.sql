INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
              
              
INSERT INTO zavrsni.reprezentacija(id,naziv,oznaka) VALUES (1,'Srbija','SRB');
INSERT INTO zavrsni.reprezentacija(id,naziv,oznaka) VALUES (2,'Cile','CIL');
INSERT INTO zavrsni.reprezentacija(id,naziv,oznaka) VALUES (3,'Crna Gora','MNE');
INSERT INTO zavrsni.reprezentacija(id,naziv,oznaka) VALUES (4,'Japan','JAP');
INSERT INTO zavrsni.reprezentacija(id,naziv,oznaka) VALUES (5,'Francuska','FRA');
INSERT INTO zavrsni.reprezentacija(id,naziv,oznaka) VALUES (6,'Egipat','EGI');
INSERT INTO zavrsni.reprezentacija(id,naziv,oznaka) VALUES (7,'Rusija','RUS');
INSERT INTO zavrsni.reprezentacija(id,naziv,oznaka) VALUES (8,'Kambodza','KAM');

INSERT INTO zavrsni.igrac(id,ime,postignuti_golovi,prezime,reprezentacija_id) VALUES (1,'Aleksandar',4,'Mitrovic',1); 
INSERT INTO zavrsni.igrac(id,ime,prezime,postignuti_golovi,reprezentacija_id) VALUES (2,'Dusan','Tadic',5,1); 
INSERT INTO zavrsni.igrac(id,ime,postignuti_golovi,prezime,reprezentacija_id) VALUES (3,'Nemanja',14,'Pavkov',1);

INSERT INTO zavrsni.igrac(id,ime,postignuti_golovi,prezime,reprezentacija_id) VALUES (4,'Alexis',4,'Sancez',2); 
INSERT INTO zavrsni.igrac(id,ime,postignuti_golovi,prezime,reprezentacija_id) VALUES (5,'Gary',0,'Medel',2);

INSERT INTO zavrsni.igrac(id,ime,postignuti_golovi,prezime,reprezentacija_id) VALUES (6,'Aleksej',4,'Martinovic',3); 
INSERT INTO zavrsni.igrac(id,ime,postignuti_golovi,prezime,reprezentacija_id) VALUES (7,'Stefan',4,'Martinovic',3);

INSERT INTO zavrsni.igrac(id,ime,postignuti_golovi,prezime,reprezentacija_id) VALUES (8,'Jang',4,'Ju',4); 
INSERT INTO zavrsni.igrac(id,ime,postignuti_golovi,prezime,reprezentacija_id) VALUES (9,'Jang',4,'Ju',4); 

INSERT INTO zavrsni.igrac(id,ime,postignuti_golovi,prezime,reprezentacija_id) VALUES (10,'Karim',5,'Benzema',5); 
INSERT INTO zavrsni.igrac(id,ime,postignuti_golovi,prezime,reprezentacija_id) VALUES (11,'Benjamin',3,'Pavard',5); 

INSERT INTO zavrsni.igrac(id,ime,postignuti_golovi,prezime,reprezentacija_id) VALUES (12,'Mohamed',2,'Abdelmonem',6); 
INSERT INTO zavrsni.igrac(id,ime,postignuti_golovi,prezime,reprezentacija_id) VALUES (13,'Mohamed',2,'Salah',6); 

INSERT INTO zavrsni.igrac(id,ime,postignuti_golovi,prezime,reprezentacija_id) VALUES (14,'Alexander',6,'Sobolev',7); 
INSERT INTO zavrsni.igrac(id,ime,postignuti_golovi,prezime,reprezentacija_id) VALUES (15,'Dmitri',6,'Barinov',7); 

INSERT INTO zavrsni.utakmica(id,reprezentacijaa_id,reprezentacijab_id,broj_golovaa,broj_golovab) VALUES (1,1,2,2,1);
INSERT INTO zavrsni.utakmica(id,reprezentacijaa_id,reprezentacijab_id,broj_golovaa,broj_golovab) VALUES (2,3,4,3,1); 
INSERT INTO zavrsni.utakmica(id,reprezentacijaa_id,reprezentacijab_id,broj_golovaa,broj_golovab) VALUES (3,5,6,1,3); 
INSERT INTO zavrsni.utakmica(id,reprezentacijaa_id,reprezentacijab_id,broj_golovaa,broj_golovab) VALUES (4,1,7,3,0); 
INSERT INTO zavrsni.utakmica(id,reprezentacijaa_id,reprezentacijab_id,broj_golovaa,broj_golovab) VALUES (5,6,2,2,2);
INSERT INTO zavrsni.utakmica(id,reprezentacijaa_id,reprezentacijab_id,broj_golovaa,broj_golovab) VALUES (6,4,5,2,3);
INSERT INTO zavrsni.utakmica(id,reprezentacijaa_id,reprezentacijab_id,broj_golovaa,broj_golovab) VALUES (7,1,4,4,3);
INSERT INTO zavrsni.utakmica(id,reprezentacijaa_id,reprezentacijab_id,broj_golovaa,broj_golovab) VALUES (8,2,7,3,3);
INSERT INTO zavrsni.utakmica(id,reprezentacijaa_id,reprezentacijab_id,broj_golovaa,broj_golovab) VALUES (9,3,5,2,2);


