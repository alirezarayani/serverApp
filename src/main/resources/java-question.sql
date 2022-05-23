INSERT into programming_language(id, language)
values (1, 'java')
INSERT into programming_language(id, language)
values (2, 'angular')
------------------------------------------------------------------------

insert into question (id, description, difficulty, question, language_id)
values (1, null, 1, 'The keywords AND, IN, LIKE, and between all belong to a category called what?', 1);

insert into answer (id, answer, fk_question_id)
values (1, ' joining operations', 1);
insert into answer (id, answer, fk_question_id)
values (2, 'linking operations', 1);
insert into answer (id, answer, fk_question_id)
values (3, 'criteria operations', 1);
insert into answer (id, answer, fk_question_id)
values (4, ' logical operations', 1);

------------------------------------------------------------------------

insert into question (id, description, difficulty, question, language_id)
values (2, 'BEGIN TRY
SELECT ''Foo'' AS Result;
END TRY
BEGIN CATCH
SELECT ''Bar'' AS Result;
END CATCH', 1, 'What is the result of this series of statements?', 1);

insert into answer (id, answer, fk_question_id)
values (5, 'Foo', 2);
insert into answer (id, answer, fk_question_id)
values (6, 'FooBar', 3);
insert into answer (id, answer, fk_question_id)
values (7, 'Foo Bar', 2);
insert into answer (id, answer, fk_question_id)
values (8, 'Foo', 2);
