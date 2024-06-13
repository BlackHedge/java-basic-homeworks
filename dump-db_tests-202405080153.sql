--
-- PostgreSQL database cluster dump
--

-- Started on 2024-05-08 01:53:48

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS;

--
-- User Configurations
--








--
-- Databases
--

--
-- Database "tests" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

-- Started on 2024-05-08 01:53:48

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4900 (class 1262 OID 16416)
-- Name: tests; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE tests WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';


ALTER DATABASE tests OWNER TO postgres;

\connect tests

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 225 (class 1259 OID 16538)
-- Name: assignee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.assignee (
    record_id integer NOT NULL,
    test_id integer NOT NULL,
    user_name character varying NOT NULL
);


ALTER TABLE public.assignee OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16537)
-- Name: assignee_record_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.assignee_record_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.assignee_record_id_seq OWNER TO postgres;

--
-- TOC entry 4901 (class 0 OID 0)
-- Dependencies: 224
-- Name: assignee_record_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.assignee_record_id_seq OWNED BY public.assignee.record_id;


--
-- TOC entry 221 (class 1259 OID 16512)
-- Name: question_in_test; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.question_in_test (
    test_id integer NOT NULL,
    question_id integer NOT NULL
);


ALTER TABLE public.question_in_test OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16488)
-- Name: questions_description; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.questions_description (
    question_id integer NOT NULL,
    question_text character varying NOT NULL
);


ALTER TABLE public.questions_description OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16487)
-- Name: questions_description_question_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.questions_description_question_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.questions_description_question_id_seq OWNER TO postgres;

--
-- TOC entry 4902 (class 0 OID 0)
-- Dependencies: 217
-- Name: questions_description_question_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.questions_description_question_id_seq OWNED BY public.questions_description.question_id;


--
-- TOC entry 226 (class 1259 OID 16551)
-- Name: test_results; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.test_results (
    record_id integer NOT NULL,
    test_id integer NOT NULL,
    question_id integer NOT NULL,
    chosen_var integer,
    var_is_correct boolean DEFAULT false NOT NULL
);


ALTER TABLE public.test_results OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16527)
-- Name: testers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.testers (
    id integer NOT NULL,
    user_name character varying NOT NULL
);


ALTER TABLE public.testers OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16526)
-- Name: testers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.testers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.testers_id_seq OWNER TO postgres;

--
-- TOC entry 4903 (class 0 OID 0)
-- Dependencies: 222
-- Name: testers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.testers_id_seq OWNED BY public.testers.id;


--
-- TOC entry 215 (class 1259 OID 16471)
-- Name: tests; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tests (
    test_id integer NOT NULL,
    test_name character varying NOT NULL
);


ALTER TABLE public.tests OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16478)
-- Name: tests_test_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tests_test_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tests_test_id_seq OWNER TO postgres;

--
-- TOC entry 4904 (class 0 OID 0)
-- Dependencies: 216
-- Name: tests_test_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tests_test_id_seq OWNED BY public.tests.test_id;


--
-- TOC entry 220 (class 1259 OID 16497)
-- Name: variants; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variants (
    question_id integer NOT NULL,
    var_num integer NOT NULL,
    var_text character varying NOT NULL,
    is_correct boolean DEFAULT false NOT NULL,
    CONSTRAINT var_num_check CHECK (((var_num < 6) AND (var_num > 0)))
);


ALTER TABLE public.variants OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16496)
-- Name: variants_question_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.variants_question_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.variants_question_id_seq OWNER TO postgres;

--
-- TOC entry 4905 (class 0 OID 0)
-- Dependencies: 219
-- Name: variants_question_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.variants_question_id_seq OWNED BY public.variants.question_id;


--
-- TOC entry 4720 (class 2604 OID 16541)
-- Name: assignee record_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assignee ALTER COLUMN record_id SET DEFAULT nextval('public.assignee_record_id_seq'::regclass);


--
-- TOC entry 4717 (class 2604 OID 16491)
-- Name: questions_description question_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.questions_description ALTER COLUMN question_id SET DEFAULT nextval('public.questions_description_question_id_seq'::regclass);


--
-- TOC entry 4719 (class 2604 OID 16530)
-- Name: testers id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.testers ALTER COLUMN id SET DEFAULT nextval('public.testers_id_seq'::regclass);


--
-- TOC entry 4716 (class 2604 OID 16479)
-- Name: tests test_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tests ALTER COLUMN test_id SET DEFAULT nextval('public.tests_test_id_seq'::regclass);


--
-- TOC entry 4893 (class 0 OID 16538)
-- Dependencies: 225
-- Data for Name: assignee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.assignee (record_id, test_id, user_name) FROM stdin;
1	1	user1
2	1	user1
3	2	user2
4	4	user2
\.


--
-- TOC entry 4889 (class 0 OID 16512)
-- Dependencies: 221
-- Data for Name: question_in_test; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.question_in_test (test_id, question_id) FROM stdin;
1	1
1	2
2	287
2	546
4	3
4	4
4	5
4	6
4	7
\.


--
-- TOC entry 4886 (class 0 OID 16488)
-- Dependencies: 218
-- Data for Name: questions_description; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.questions_description (question_id, question_text) FROM stdin;
546	Зачем?
287	Когда делать домашку?
1	Кто готов?
2	Где жить?
3	Кошка или акула?
4	Корова или дуб?
5	Попугай или собака?
6	Он или Оно?
7	Через И или Ы?
\.


--
-- TOC entry 4894 (class 0 OID 16551)
-- Dependencies: 226
-- Data for Name: test_results; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.test_results (record_id, test_id, question_id, chosen_var, var_is_correct) FROM stdin;
1	1	1	1	t
1	1	2	1	f
4	4	3	1	f
4	4	4	2	f
4	4	5	\N	f
4	4	6	\N	f
4	4	7	\N	f
\.


--
-- TOC entry 4891 (class 0 OID 16527)
-- Dependencies: 223
-- Data for Name: testers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.testers (id, user_name) FROM stdin;
1	admin
2	user1
4	user2
\.


--
-- TOC entry 4883 (class 0 OID 16471)
-- Dependencies: 215
-- Data for Name: tests; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tests (test_id, test_name) FROM stdin;
1	Тест на сообразительность
2	Странные вопросы
3	Угадай кто
4	Животные
5	Автомобили
6	IQ
7	ПДД
\.


--
-- TOC entry 4888 (class 0 OID 16497)
-- Dependencies: 220
-- Data for Name: variants; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.variants (question_id, var_num, var_text, is_correct) FROM stdin;
1	1	Никто	t
1	2	Все	f
2	1	Везде	f
2	2	Нигде	f
287	1	Завтра	f
287	2	Сегодня	f
287	3	Вчера	f
2	3	Дома	t
287	4	Послезавтра	f
287	5	Позавчера	t
546	1	ачебынет	f
3	1	Кошка	t
3	2	Акула	f
4	1	Корова	t
4	2	Дуб	f
5	1	Попугай	f
5	2	Собака	t
6	1	Он	f
6	2	Оно	t
7	1	Через И	t
7	2	Через Ы	f
\.


--
-- TOC entry 4906 (class 0 OID 0)
-- Dependencies: 224
-- Name: assignee_record_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.assignee_record_id_seq', 4, true);


--
-- TOC entry 4907 (class 0 OID 0)
-- Dependencies: 217
-- Name: questions_description_question_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.questions_description_question_id_seq', 7, true);


--
-- TOC entry 4908 (class 0 OID 0)
-- Dependencies: 222
-- Name: testers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.testers_id_seq', 4, true);


--
-- TOC entry 4909 (class 0 OID 0)
-- Dependencies: 216
-- Name: tests_test_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tests_test_id_seq', 7, true);


--
-- TOC entry 4910 (class 0 OID 0)
-- Dependencies: 219
-- Name: variants_question_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.variants_question_id_seq', 1, false);


--
-- TOC entry 4734 (class 2606 OID 16545)
-- Name: assignee assignee_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assignee
    ADD CONSTRAINT assignee_pk PRIMARY KEY (record_id);


--
-- TOC entry 4726 (class 2606 OID 16495)
-- Name: questions_description questions_description_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.questions_description
    ADD CONSTRAINT questions_description_pk PRIMARY KEY (question_id);


--
-- TOC entry 4730 (class 2606 OID 16534)
-- Name: testers testers_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.testers
    ADD CONSTRAINT testers_pk PRIMARY KEY (id);


--
-- TOC entry 4732 (class 2606 OID 16536)
-- Name: testers testers_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.testers
    ADD CONSTRAINT testers_unique UNIQUE (user_name);


--
-- TOC entry 4724 (class 2606 OID 16484)
-- Name: tests tests_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tests
    ADD CONSTRAINT tests_pk PRIMARY KEY (test_id);


--
-- TOC entry 4728 (class 2606 OID 16505)
-- Name: variants variants_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variants
    ADD CONSTRAINT variants_unique UNIQUE (question_id, var_num);


--
-- TOC entry 4738 (class 2606 OID 16546)
-- Name: assignee assignee_tests_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assignee
    ADD CONSTRAINT assignee_tests_fk FOREIGN KEY (test_id) REFERENCES public.tests(test_id);


--
-- TOC entry 4736 (class 2606 OID 16520)
-- Name: question_in_test question_in_test_questions_description_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question_in_test
    ADD CONSTRAINT question_in_test_questions_description_fk FOREIGN KEY (question_id) REFERENCES public.questions_description(question_id);


--
-- TOC entry 4737 (class 2606 OID 16515)
-- Name: question_in_test question_in_test_tests_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question_in_test
    ADD CONSTRAINT question_in_test_tests_fk FOREIGN KEY (test_id) REFERENCES public.tests(test_id);


--
-- TOC entry 4739 (class 2606 OID 16555)
-- Name: test_results test_results_assignee_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.test_results
    ADD CONSTRAINT test_results_assignee_fk FOREIGN KEY (record_id) REFERENCES public.assignee(record_id);


--
-- TOC entry 4735 (class 2606 OID 16506)
-- Name: variants variants_questions_description_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variants
    ADD CONSTRAINT variants_questions_description_fk FOREIGN KEY (question_id) REFERENCES public.questions_description(question_id);


-- Completed on 2024-05-08 01:53:48

--
-- PostgreSQL database dump complete
--

-- Completed on 2024-05-08 01:53:48

--
-- PostgreSQL database cluster dump complete
--

