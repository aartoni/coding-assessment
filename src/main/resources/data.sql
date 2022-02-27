INSERT INTO user (username) VALUES ('first-user')
INSERT INTO user (username) VALUES ('second-user')

INSERT INTO task (title, text, checked, last_update, user_id) VALUES ('Lorem ipsum', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec cursus sed massa non mollis. Donec fermentum purus in cursus iaculis. Interdum et malesuada fames ac ante ipsum primis in faucibus.', FALSE, {ts '2022-09-17 18:47:52.34'}, 1)
INSERT INTO task (title, text, checked, last_update, user_id) VALUES ('Lorem ipsum pt. 2', 'Sed pretium pulvinar leo, eu viverra sem bibendum ac. Aenean in arcu non ante commodo eleifend. Nulla hendrerit aliquet ullamcorper. Quisque non ligula porttitor, ultricies leo sed, sodales elit. Ut gravida odio vel purus porta egestas.', FALSE, {ts '2022-09-18 15:21:43.41'}, 1)
INSERT INTO task (title, text, checked, last_update, user_id) VALUES ('Test second user', 'This is another user, please refer to it as the second user', FALSE, {ts '2022-11-17 18:47:52.34'}, 2)
