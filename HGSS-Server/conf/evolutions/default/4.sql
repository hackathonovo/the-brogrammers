INSERT INTO hgssaction (id, description) VALUES (1, 'Description of Action1');
INSERT INTO hgssaction (id, description) VALUES (2, 'Description of Action2');

INSERT INTO hgsszone (id, hgssaction_id) VALUES (1, 1);
INSERT INTO hgsszone (id, hgssaction_id) VALUES (2, 2);

INSERT INTO hgsslocation (hgsszone_id, longitude, latitude) VALUES (1, 46.392, 16.418);
INSERT INTO hgsslocation (hgsszone_id, longitude, latitude) VALUES (1, 46.592, 16.418);
INSERT INTO hgsslocation (hgsszone_id, longitude, latitude) VALUES (1, 46.592, 16.218);
INSERT INTO hgsslocation (hgsszone_id, longitude, latitude) VALUES (1, 46.392, 16.218);

INSERT INTO hgsslocation (hgsszone_id, longitude, latitude) VALUES (2, 45.787, 16.754);
INSERT INTO hgsslocation (hgsszone_id, longitude, latitude) VALUES (2, 45.987, 16.754);
INSERT INTO hgsslocation (hgsszone_id, longitude, latitude) VALUES (2, 45.987, 16.554);
INSERT INTO hgsslocation (hgsszone_id, longitude, latitude) VALUES (2, 45.787, 16.554);