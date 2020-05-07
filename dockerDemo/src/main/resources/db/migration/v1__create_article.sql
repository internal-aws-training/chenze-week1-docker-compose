CREATE TABLE `article` (
    `id` bigint(20) unsigned NOT NULL,
    `title` varchar(50) NOT NULL default '',
    `content` varchar(100) NOT NULL default '',
    PRIMARY KEY (`id`)
);