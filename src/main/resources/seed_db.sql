-- Optional: 
-- podman run -d --name mysql57 -p 3306:3306 -e MYSQL_ROOT_PASSWORD='%root_password%' -e MYSQL_USER=%app_username% -e MYSQL_PASSWORD='%app_password%' -e MYSQL_DATABASE=springdemo mysql:5.7
-- Note: As no volume attached the data will be lost along with container if removed.

-- Create table
CREATE TABLE item (   
id INT NOT NULL AUTO_INCREMENT,   
item VARCHAR (20) NOT NULL,   
category VARCHAR (20)  NOT NULL,   
available CHAR (1),   
PRIMARY KEY (id)   
);  

-- Grant priv to connect from any host
-- Run as mysql's root
GRANT ALL PRIVILEGES ON *.* TO '%app_username%'@'%' IDENTIFIED BY '%app_password%' WITH GRANT OPTION;