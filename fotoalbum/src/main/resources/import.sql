INSERT INTO db_photoalbum.categories(name) VALUES('doggo');
INSERT INTO db_photoalbum.categories(name) VALUES('pesaggi');
INSERT INTO db_photoalbum.categories(name) VALUES('varie');
INSERT INTO db_photoalbum.foto_album(img_url, title, visible) VALUES('https://media.wired.com/photos/5a55457ef41e4c2cd9ee6cb5/master/w_2560%2Cc_limit/Doggo-TopArt-104685145.jpg', 'doggo1', 1);
INSERT INTO db_photoalbum.foto_album(img_url, title, visible) VALUES( 'https://i1.sndcdn.com/artworks-000810672895-5vv94q-t500x500.jpg', 'doggo2', 0);
INSERT INTO db_photoalbum.foto_album(img_url, title, visible) VALUES( 'https://www.purinashop.it/media/mageplaza/blog/post/resize/930x930/p/r/probiotici_cane.jpg', 'doggo landscape', 0);
INSERT INTO db_photoalbum.foto_album(img_url, title, visible) VALUES( 'https://www.repstatic.it/content/contenthub/img/2023/01/20/195906100-48bd958b-a74a-4b7e-ad5a-096e18f33459.jpg', 'doggo landscape varie', 1);
INSERT INTO db_photoalbum.category_foto_album(foto_album_id, category_id)VALUES(1, 1);
INSERT INTO db_photoalbum.category_foto_album(foto_album_id, category_id)VALUES(2, 1);
INSERT INTO db_photoalbum.category_foto_album(foto_album_id, category_id)VALUES(3, 1);
INSERT INTO db_photoalbum.category_foto_album(foto_album_id, category_id)VALUES(3, 2);
INSERT INTO db_photoalbum.category_foto_album(foto_album_id, category_id)VALUES(4, 1);
INSERT INTO db_photoalbum.category_foto_album(foto_album_id, category_id)VALUES(4, 2);
INSERT INTO db_photoalbum.category_foto_album(foto_album_id, category_id)VALUES(4, 3);

