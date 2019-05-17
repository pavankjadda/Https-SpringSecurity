
/* Insert Data into User Table  */
INSERT INTO `httpsspringsecurity`.`user`(`id`, `active`, `username`, `password`)
VALUES (1001, true, 'admin', '$2a$12$lkl.PF9eGBW/iofHhophlOWD3KEmSKqMXYrufsU9g5TMnio7N8JOK');
INSERT INTO `httpsspringsecurity`.`user`(`id`, `active`, `username`, `password`)
VALUES (1002, true, 'user', '$2a$12$tBTv6hgDYME.QePjkXEdxOnYhi95zPtamm6NskNuSA5XeTtJKGhzS');


insert into httpsspringsecurity.role values(1,'ROLE_USER');
insert into httpsspringsecurity.role values(2,'ROLE_ADMIN');
insert into httpsspringsecurity.role values(3,'ROLE_APIUSER');
insert into httpsspringsecurity.role values(4,'ROLE_DBA');
insert into httpsspringsecurity.role values(5,'ROLE_SELLER');
insert into httpsspringsecurity.role values(6,'ROLE_BUYER');

/* Insert Data into Privilege Table  */
insert into httpsspringsecurity.privilege values(1,'READ_PRIVILEGE');
insert into httpsspringsecurity.privilege values(2,'WRITE_PRIVILEGE');
insert into httpsspringsecurity.privilege values(3,'DELETE_PRIVILEGE');

/* Insert Data into UserRole Table  */
INSERT INTO `httpsspringsecurity`.`user_role`(`id`,`user_id`,`role_id`) VALUES (1,2,1);
INSERT INTO `httpsspringsecurity`.`user_role`(`id`,`user_id`,`role_id`) VALUES (2,1,2);
INSERT INTO `httpsspringsecurity`.`user_role`(`id`,`user_id`,`role_id`) VALUES (3,1,1);

/* Insert Data into RolePrivilege Table  */
insert into httpsspringsecurity.role_privilege values(2,1);
insert into httpsspringsecurity.role_privilege values(2,2);
insert into httpsspringsecurity.role_privilege values(2,3);
insert into httpsspringsecurity.role_privilege values(1,1);
