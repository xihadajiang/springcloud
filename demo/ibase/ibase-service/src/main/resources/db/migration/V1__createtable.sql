use springcloud;
CREATE TABLE `t_ba_test` (
  `id` varchar(64) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `account` varchar(32) DEFAULT NULL,
  `is_default` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_ba_syslog` (
  `syslog_id` varchar(64) NOT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  `domain_id` varchar(64) DEFAULT NULL,
  `org_id` varchar(64) DEFAULT NULL,
  `log_date` date DEFAULT NULL,
  PRIMARY KEY (`syslog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_ba_user22222` (
  `id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `account` varchar(64) DEFAULT NULL,
  `is_default` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
