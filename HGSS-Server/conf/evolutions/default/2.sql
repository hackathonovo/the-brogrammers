INSERT INTO hgssstation (id, station_name, longitude, latitude)
  VALUES (1, 'Bjelovar', 45.887, 16.854);

INSERT INTO hgssstation (id, station_name, longitude, latitude)
  VALUES (2, 'Delnice', 45.399, 14.803);

INSERT INTO hgssstation (id, station_name, longitude, latitude)
VALUES (3, 'Čakovec', 46.392, 16.418);

ALTER SEQUENCE hgssstation_seq RESTART WITH 10;

INSERT INTO hgssuser (id, username, password, first_name, last_name, role, skill, is_available, station_id)
  VALUES (1, 'admin', 'admin', 'Teo', 'Toplak', 'ROLE1', 'SKILL1', FALSE, 1);
INSERT INTO hgssuser (id, username, password, first_name, last_name, role, skill, is_available, station_id)
  VALUES (2, 'vsako', 'admin', 'Viseslav', 'Sako', 'ROLE2', 'SKILL2', TRUE, 2);
INSERT INTO hgssuser (id, username, password, first_name, last_name, role, skill, is_available, station_id)
  VALUES (3, 'hbaric', 'admin', 'Hari', 'Baric', 'ROLE3', 'SKILL3', TRUE, 2);
INSERT INTO hgssuser (id, username, password, first_name, last_name, role, skill, is_available, station_id)
  VALUES (4, 'dpenic', 'admin', 'Domagoj', 'Penic', 'ROLE3', 'SKILL2', FALSE, 3);
INSERT INTO hgssuser (id, username, password, first_name, last_name, role, skill, is_available, station_id)
  VALUES (5, 'pperic', 'admin', 'Pero', 'Peric', 'ROLE3', 'SKILL1', TRUE, 3);

ALTER SEQUENCE hgssuser_seq RESTART WITH 10;

INSERT INTO hgssaction (id, description) VALUES (1, 'Description of Action1');
INSERT INTO hgssaction (id, description) VALUES (2, 'Description of Action2');

ALTER SEQUENCE hgssaction_seq RESTART WITH 10;

INSERT INTO hgsszone (id, hgssaction_id) VALUES (1, 1);
INSERT INTO hgsszone (id, hgssaction_id) VALUES (2, 2);

ALTER SEQUENCE hgsszone_seq RESTART WITH 10;

INSERT INTO hgsslocation (hgsszone_id, longitude, latitude) VALUES (1, 46.392, 16.418);
INSERT INTO hgsslocation (hgsszone_id, longitude, latitude) VALUES (1, 46.592, 16.418);
INSERT INTO hgsslocation (hgsszone_id, longitude, latitude) VALUES (1, 46.592, 16.218);
INSERT INTO hgsslocation (hgsszone_id, longitude, latitude) VALUES (1, 46.392, 16.218);

INSERT INTO hgsslocation (hgsszone_id, longitude, latitude) VALUES (2, 45.787, 16.754);
INSERT INTO hgsslocation (hgsszone_id, longitude, latitude) VALUES (2, 45.987, 16.754);
INSERT INTO hgsslocation (hgsszone_id, longitude, latitude) VALUES (2, 45.987, 16.554);
INSERT INTO hgsslocation (hgsszone_id, longitude, latitude) VALUES (2, 45.787, 16.554);