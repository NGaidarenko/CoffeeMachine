create table coffee_machine.ingredient (
                                 id bigint generated by default as identity,
                                 name varchar(255) not null,
                                 quantity integer not null,
                                 primary key (id)
);
create table coffee_machine.orders (
                             id bigint generated by default as identity,
                             date timestamp(6),
                             recipe_id bigint,
                             primary key (id)
);
create table coffee_machine.recipe (
                             id bigint generated by default as identity,
                             name varchar(255),
                             primary key (id)
);
create table coffee_machine.recipe_ingredients (
                                         recipe_id bigint not null,
                                         quantity integer,
                                         ingredient_id bigint not null,
                                         primary key (recipe_id, ingredient_id)
);
create table coffee_machine.statistics (
                                 id bigint generated by default as identity,
                                 order_count integer not null,
                                 recipe_id bigint not null,
                                 primary key (id)
);
alter table if exists coffee_machine.statistics drop constraint if exists UKt6f74bnvwjk28boyi724srfex;

alter table if exists coffee_machine.statistics add constraint UKt6f74bnvwjk28boyi724srfex unique (recipe_id);
alter table if exists coffee_machine.orders add constraint FKd9qupxrei167bh1s55wlf1x7w foreign key (recipe_id) references coffee_machine.recipe;
alter table if exists coffee_machine.recipe_ingredients add constraint FKhnsmvxdlwxqq6x2wbgnoef5gr foreign key (recipe_id) references coffee_machine.recipe;
alter table if exists coffee_machine.statistics add constraint FKnul05qcwqo85jvprm01p80vyk foreign key (recipe_id) references coffee_machine.recipe;