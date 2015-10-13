INSERT INTO event (id, band, city, date, venue) VALUES (5, 'Overkill', 'Swansea', '12/03/16', 'The Vault');


select b.band_id, b.name, e.venue, e.city from band b
inner join event_bands eb on eb.band_id = b.band_id
inner join event e on e.event_id = eb.event_id
where b.name = 'Metallica';
