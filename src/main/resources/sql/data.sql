--
-- PostgreSQL database dump
--

-- Dumped from database version 10.7
-- Dumped by pg_dump version 10.7

-- Started on 2020-07-13 02:25:44

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2840 (class 0 OID 16625)
-- Dependencies: 202
-- Data for Name: quiz; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.quiz (id_quiz, theme_quiz) FROM stdin;
1	Culture General 1 
2	Culture General 2
\.


--
-- TOC entry 2837 (class 0 OID 16618)
-- Dependencies: 199
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.question (id_question, text_question, id_quiz) FROM stdin;
1	Quel est la capital de la France ? 	1
2	1+1=?	1
3	2+2=?	1
4	3+3=?	1
5	4+4=?	1
6	5+5=?	2
7	6+6=?	2
8	7+7=?	2
9	1+?=10	2
10	5x10=?	2
\.


--
-- TOC entry 2834 (class 0 OID 16611)
-- Dependencies: 196
-- Data for Name: answer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.answer (id_answer, text_answer, validity_answer, id_question) FROM stdin;
1	Paris	t	1
2	Madrid	f	1
3	Montpellier	f	1
4	Toulouse	f	1
9	3	f	3
10	4	t	3
11	5	f	3
12	6	f	3
13	3	f	4
14	4	f	4
15	5	f	4
16	6	t	4
17	8	t	5
18	9	f	5
19	10	f	5
20	11	f	5
5	2	t	2
6	3	f	2
7	4	f	2
8	5	f	2
21	on est ou	f	6
\.


--
-- TOC entry 2841 (class 0 OID 16628)
-- Dependencies: 203
-- Data for Name: score; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.score (id_score, pseudo, final_score, "time", date, id_quiz) FROM stdin;
1	Blizcrank	5	10	2010-10-10	1
2	Lucio	4	15	2010-10-10	1
\.


--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 197
-- Name: answer_id_answer_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.answer_id_answer_seq', 1, false);


--
-- TOC entry 2850 (class 0 OID 0)
-- Dependencies: 198
-- Name: answer_id_question_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.answer_id_question_seq', 1, true);


--
-- TOC entry 2851 (class 0 OID 0)
-- Dependencies: 200
-- Name: question_id_question_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.question_id_question_seq', 1, false);


--
-- TOC entry 2852 (class 0 OID 0)
-- Dependencies: 201
-- Name: question_id_quiz_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.question_id_quiz_seq', 1, false);


--
-- TOC entry 2853 (class 0 OID 0)
-- Dependencies: 204
-- Name: score_id_quiz_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.score_id_quiz_seq', 1, false);


--
-- TOC entry 2854 (class 0 OID 0)
-- Dependencies: 205
-- Name: score_id_score_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.score_id_score_seq', 1, false);


-- Completed on 2020-07-13 02:25:45

--
-- PostgreSQL database dump complete
--

