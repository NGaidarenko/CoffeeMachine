insert into coffee_machine.ingredient (name,quantity) values ('Молоко', 0) returning id;
insert into coffee_machine.ingredient (name,quantity) values ('Кофе', 0) returning id;
insert into coffee_machine.ingredient (name,quantity) values ('Сахар', 0) returning id;
insert into coffee_machine.ingredient (name,quantity) values ('Вода',0) returning id;


insert into coffee_machine.recipe (name) values ('Эспрессо') returning id;
insert into coffee_machine.recipe_ingredients (recipe_id,ingredient_id,quantity) values (1,2,15);
insert into coffee_machine.recipe_ingredients (recipe_id,ingredient_id,quantity) values (1,4,50);
insert into coffee_machine.statistics (order_count,recipe_id) values (0,1) returning id;

insert into coffee_machine.recipe (name) values ('Американо') returning id;
insert into coffee_machine.recipe_ingredients (recipe_id,ingredient_id,quantity) values (2,2,30);
insert into coffee_machine.recipe_ingredients (recipe_id,ingredient_id,quantity) values (2,4,100);
insert into coffee_machine.statistics (order_count,recipe_id) values (0,2) returning id;

insert into coffee_machine.recipe (name) values ('Капучино') returning id;
insert into coffee_machine.recipe_ingredients (recipe_id,ingredient_id,quantity) values (3,2,30);
insert into coffee_machine.recipe_ingredients (recipe_id,ingredient_id,quantity) values (3,3,20);
insert into coffee_machine.recipe_ingredients (recipe_id,ingredient_id,quantity) values (3,4,100);
insert into coffee_machine.recipe_ingredients (recipe_id,ingredient_id,quantity) values (3,1,50);
insert into coffee_machine.statistics (order_count,recipe_id) values (0,3) returning id;