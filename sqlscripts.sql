create TABLE complaints (
id INT NOT NULL AUTO_INCREMENT,
message varchar(64),
sender_Name varchar(30),
sender_email varchar(50),
PRIMARY KEY (id)
);

//use varchar(16300) for message.