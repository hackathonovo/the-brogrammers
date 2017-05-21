INSERT INTO hgssaction_type (id, action_type) VALUES (1, 'ActionType1');
INSERT INTO hgssaction_type (id, action_type) VALUES (2, 'ActionType2');
INSERT INTO hgssaction_type (id, action_type) VALUES (3, 'ActionType3');
INSERT INTO hgssaction_type (id, action_type) VALUES (4, 'ActionType4');

ALTER SEQUENCE hgssaction_type_seq RESTART WITH 10;

INSERT INTO hgssrole (id, role) VALUES (1, 'Role1');
INSERT INTO hgssrole (id, role) VALUES (2, 'Role2');
INSERT INTO hgssrole (id, role) VALUES (3, 'Role3');

ALTER SEQUENCE hgssrole_seq RESTART WITH 10;

INSERT INTO hgssskill (id, skill) VALUES (1, 'Skill1');
INSERT INTO hgssskill (id, skill) VALUES (2, 'Skill2');
INSERT INTO hgssskill (id, skill) VALUES (3, 'Skill3');

ALTER SEQUENCE hgssskill_seq RESTART WITH 10;

INSERT INTO hgssstation (id, station_name, longitude, latitude)
  VALUES (1, 'Bjelovar', 45.887, 16.854);

INSERT INTO hgssstation (id, station_name, longitude, latitude)
  VALUES (2, 'Delnice', 45.399, 14.803);

INSERT INTO hgssstation (id, station_name, longitude, latitude)
VALUES (3, 'Čakovec', 46.392, 16.418);

ALTER SEQUENCE hgssstation_seq RESTART WITH 10;

INSERT INTO hgssuser (id, username, password, first_name, last_name, role_id, skill_id, is_available, station_id, phone_number, location_name, location_long, location_lat)
  VALUES (1, 'admin', 'admin', 'Teo', 'Toplak', 1, 1, FALSE, 1, '385995109450', 'Delnice', 45.826925, 15.883377);
INSERT INTO hgssuser (id, username, password, first_name, last_name, role_id, skill_id, is_available, station_id, phone_number, location_name, location_long, location_lat)
  VALUES (2, 'vsako', 'admin', 'Viseslav', 'Sako', 2, 3, TRUE, 2, '385996811041', 'Delnice', 45.626925, 15.883377);
INSERT INTO hgssuser (id, username, password, first_name, last_name, role_id, skill_id, is_available, station_id, phone_number, location_name, location_long, location_lat)
  VALUES (3, 'hbaric', 'admin', 'Hari', 'Baric', 2, 2, TRUE, 2, '385917306800', 'Samobor', 45.826925, 15.683377);
INSERT INTO hgssuser (id, username, password, first_name, last_name, role_id, skill_id, is_available, station_id, phone_number, location_name, location_long, location_lat)
  VALUES (4, 'dpenic', 'admin', 'Domagoj', 'Penic', 3, 3, FALSE, 3, '385995037013', 'Samobor', 45.826925, 15.983377);
INSERT INTO hgssuser (id, username, password, first_name, last_name, role_id, skill_id, is_available, station_id, phone_number, location_name, location_long, location_lat)
  VALUES (5, 'pperic', 'admin', 'Pero', 'Peric', 3, 1, TRUE, 3, '385995037013', 'Samobor', 45.726925, 15.583377);

ALTER SEQUENCE hgssuser_seq RESTART WITH 10;

INSERT INTO hgssaction (id, title, longitude, latitude, owner_id, description, is_active, action_type_id)
  VALUES (1, 'Title1', 45.323, 15.898, 2, 'Description of Action1', TRUE, 1);
INSERT INTO hgssaction (id, title, longitude, latitude, owner_id, description, is_active, action_type_id)
  VALUES (2, 'Title2', 46.323, 16.898, 2, 'Description of Action2', TRUE, 2);

ALTER SEQUENCE hgssaction_seq RESTART WITH 10;

INSERT INTO hgsszone (id, hgssaction_id) VALUES (1, 1);
INSERT INTO hgsszone (id, hgssaction_id) VALUES (2, 2);

ALTER SEQUENCE hgsszone_seq RESTART WITH 10;

INSERT INTO hgsslocation (id, hgsszone_id, longitude, latitude) VALUES (1, 1, 46.392, 16.418);
INSERT INTO hgsslocation (id, hgsszone_id, longitude, latitude) VALUES (2, 1, 46.592, 16.418);
INSERT INTO hgsslocation (id, hgsszone_id, longitude, latitude) VALUES (3, 1, 46.592, 16.218);
INSERT INTO hgsslocation (id, hgsszone_id, longitude, latitude) VALUES (4, 1, 46.392, 16.218);

INSERT INTO hgsslocation (id, hgsszone_id, longitude, latitude) VALUES (5, 2, 45.787, 16.754);
INSERT INTO hgsslocation (id, hgsszone_id, longitude, latitude) VALUES (6, 2, 45.987, 16.754);
INSERT INTO hgsslocation (id, hgsszone_id, longitude, latitude) VALUES (7, 2, 45.987, 16.554);
INSERT INTO hgsslocation (id, hgsszone_id, longitude, latitude) VALUES (8, 2, 45.787, 16.554);

ALTER SEQUENCE hgsslocation_seq RESTART WITH 20;

INSERT INTO hgsschat_message (id, hgssaction_id, username, message, date)
    VALUES (1, 1, 'vsako', 'Bok svima, nova akcija!', '2011-05-16 15:36:38');
INSERT INTO hgsschat_message (id, hgssaction_id, username, message, date)
  VALUES (2, 1, 'pperic', 'Opet neki Ceh...', '2012-12-12 10:01:34');
INSERT INTO hgsschat_message (id, hgssaction_id, username, message, date)
  VALUES (3, 2, 'pperic', 'Meni se ne da fakat.', '2012-05-16 22:44:17');
INSERT INTO hgsschat_message (id, hgssaction_id, username, message, date)
  VALUES (4, 2, 'hbaric', 'Aj zovi ove iz Varazdina', '2015-06-26 15:36:38');
INSERT INTO hgsschat_message (id, hgssaction_id, username, message, date)
  VALUES (5, 2, 'hbaric', 'Spasili smo covjeka!', '2015-01-06 12:16:22');

ALTER SEQUENCE hgsschat_message_seq RESTART WITH 20;

INSERT INTO hgssaction_hgssuser (hgssaction_id, hgssuser_id) VALUES (1, 2);
INSERT INTO hgssaction_hgssuser (hgssaction_id, hgssuser_id) VALUES (1, 3);
INSERT INTO hgssaction_hgssuser (hgssaction_id, hgssuser_id) VALUES (1, 4);
INSERT INTO hgssaction_hgssuser (hgssaction_id, hgssuser_id) VALUES (2, 4);
INSERT INTO hgssaction_hgssuser (hgssaction_id, hgssuser_id) VALUES (2, 5);