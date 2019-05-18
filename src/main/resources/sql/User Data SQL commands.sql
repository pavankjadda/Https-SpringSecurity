
/* Insert Data into User Table  */
INSERT INTO `httpsspringsecurity`.`user`(`id`,`account_non_expired`,`account_non_locked`,`active`,`credentials_non_expired`,`password`,`username`)
VALUES (1001, true, true, true, true, '$2a$12$BJ35i2beLtpO4r.b04FZeu8Yn/fxJF.2xg15e29j.FzCpd3QV8eAS' , 'admin');

INSERT INTO `httpsspringsecurity`.`user`(`id`,`account_non_expired`,`account_non_locked`,`active`,`credentials_non_expired`,`password`,`username`)
VALUES (1002, true, true, true, true, '$2a$12$tBTv6hgDYME.QePjkXEdxOnYhi95zPtamm6NskNuSA5XeTtJKGhzS' , 'user');


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
INSERT INTO `httpsspringsecurity`.`user_role`(`id`,`user_id`,`role_id`) VALUES (4,1,3);

/* Insert Data into RolePrivilege Table  */
insert into httpsspringsecurity.role_privilege values(2,1);
insert into httpsspringsecurity.role_privilege values(2,2);
insert into httpsspringsecurity.role_privilege values(2,3);
insert into httpsspringsecurity.role_privilege values(1,1);
