INSERT INTO hgssstation (id, station_name, longitude, latitude)
  VALUES (1, 'Bjelovar', 45.887, 16.854);

INSERT INTO hgssstation (id, station_name, longitude, latitude)
  VALUES (2, 'Delnice', 45.399, 14.803);

INSERT INTO hgssstation (id, station_name, longitude, latitude)
VALUES (3, 'Čakovec', 46.392, 16.418);

ALTER SEQUENCE hgssstation_seq RESTART WITH 10;

INSERT INTO hgssuser (id, username, password, first_name, last_name, role, skill, is_available, station_id, phone_number)
  VALUES (1, 'admin', 'admin', 'Teo', 'Toplak', 'ROLE1', 'SKILL1', FALSE, 1, '385995109450');
INSERT INTO hgssuser (id, username, password, first_name, last_name, role, skill, is_available, station_id, phone_number)
  VALUES (2, 'vsako', 'admin', 'Viseslav', 'Sako', 'ROLE2', 'SKILL2', TRUE, 2, '385996811041');
INSERT INTO hgssuser (id, username, password, first_name, last_name, role, skill, is_available, station_id, phone_number)
  VALUES (3, 'hbaric', 'admin', 'Hari', 'Baric', 'ROLE3', 'SKILL3', TRUE, 2, '385917306800');
INSERT INTO hgssuser (id, username, password, first_name, last_name, role, skill, is_available, station_id, phone_number)
  VALUES (4, 'dpenic', 'admin', 'Domagoj', 'Penic', 'ROLE3', 'SKILL2', FALSE, 3, '385995037013');
INSERT INTO hgssuser (id, username, password, first_name, last_name, role, skill, is_available, station_id, phone_number)
  VALUES (5, 'pperic', 'admin', 'Pero', 'Peric', 'ROLE3', 'SKILL1', TRUE, 3, '385995037013');

ALTER SEQUENCE hgssuser_seq RESTART WITH 10;

INSERT INTO hgssaction (id, title, longitude, latitude, owner_id, description, is_active)
  VALUES (1, 'Title1', 45.323, 15.898, 2, 'Description of Action1', TRUE);
INSERT INTO hgssaction (id, title, longitude, latitude, owner_id, description, is_active)
  VALUES (2, 'Title2', 46.323, 16.898, 2, 'Description of Action2', TRUE);

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