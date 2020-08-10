--
-- PostgreSQL database dump
--

-- Dumped from database version 10.7
-- Dumped by pg_dump version 10.7

-- Started on 2020-07-12 21:37:20

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
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2841 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 16611)
-- Name: answer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.answer (
    id_answer integer NOT NULL,
    label text,
    validity_answer boolean,
    id_question integer NOT NULL
);


ALTER TABLE public.answer OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16614)
-- Name: answer_id_answer_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.answer_id_answer_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.answer_id_answer_seq OWNER TO postgres;

--
-- TOC entry 2842 (class 0 OID 0)
-- Dependencies: 197
-- Name: answer_id_answer_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.answer_id_answer_seq OWNED BY public.answer.id_answer;


--
-- TOC entry 198 (class 1259 OID 16616)
-- Name: answer_id_question_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.answer_id_question_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.answer_id_question_seq OWNER TO postgres;

--
-- TOC entry 2843 (class 0 OID 0)
-- Dependencies: 198
-- Name: answer_id_question_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.answer_id_question_seq OWNED BY public.answer.id_question;


--
-- TOC entry 199 (class 1259 OID 16618)
-- Name: question; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.question (
    id_question integer NOT NULL,
    label text,
    id_quiz integer NOT NULL
);


ALTER TABLE public.question OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16621)
-- Name: question_id_question_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.question_id_question_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.question_id_question_seq OWNER TO postgres;

--
-- TOC entry 2844 (class 0 OID 0)
-- Dependencies: 200
-- Name: question_id_question_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.question_id_question_seq OWNED BY public.question.id_question;


--
-- TOC entry 201 (class 1259 OID 16623)
-- Name: question_id_quiz_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.question_id_quiz_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.question_id_quiz_seq OWNER TO postgres;

--
-- TOC entry 2845 (class 0 OID 0)
-- Dependencies: 201
-- Name: question_id_quiz_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.question_id_quiz_seq OWNED BY public.question.id_quiz;


--
-- TOC entry 202 (class 1259 OID 16625)
-- Name: quiz; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.quiz (
    id_quiz integer NOT NULL,
    theme text
);


ALTER TABLE public.quiz OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16628)
-- Name: score; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.score (
    id_score integer NOT NULL,
    pseudo text,
    final_score integer,
    "time" integer,
    date date,
    id_quiz integer NOT NULL
);


ALTER TABLE public.score OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16631)
-- Name: score_id_quiz_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.score_id_quiz_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.score_id_quiz_seq OWNER TO postgres;

--
-- TOC entry 2846 (class 0 OID 0)
-- Dependencies: 204
-- Name: score_id_quiz_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.score_id_quiz_seq OWNED BY public.score.id_quiz;


--
-- TOC entry 205 (class 1259 OID 16633)
-- Name: score_id_score_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.score_id_score_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.score_id_score_seq OWNER TO postgres;

--
-- TOC entry 2847 (class 0 OID 0)
-- Dependencies: 205
-- Name: score_id_score_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.score_id_score_seq OWNED BY public.score.id_score;


--
-- TOC entry 2696 (class 2604 OID 16635)
-- Name: answer id_answer; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.answer ALTER COLUMN id_answer SET DEFAULT nextval('public.answer_id_answer_seq'::regclass);


--
-- TOC entry 2697 (class 2604 OID 16636)
-- Name: answer id_question; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.answer ALTER COLUMN id_question SET DEFAULT nextval('public.answer_id_question_seq'::regclass);


--
-- TOC entry 2698 (class 2604 OID 16637)
-- Name: question id_question; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question ALTER COLUMN id_question SET DEFAULT nextval('public.question_id_question_seq'::regclass);


--
-- TOC entry 2699 (class 2604 OID 16638)
-- Name: question id_quiz; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question ALTER COLUMN id_quiz SET DEFAULT nextval('public.question_id_quiz_seq'::regclass);


--
-- TOC entry 2700 (class 2604 OID 16639)
-- Name: score id_score; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.score ALTER COLUMN id_score SET DEFAULT nextval('public.score_id_score_seq'::regclass);


--
-- TOC entry 2701 (class 2604 OID 16640)
-- Name: score id_quiz; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.score ALTER COLUMN id_quiz SET DEFAULT nextval('public.score_id_quiz_seq'::regclass);


--
-- TOC entry 2703 (class 2606 OID 16642)
-- Name: answer answer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.answer
    ADD CONSTRAINT answer_pkey PRIMARY KEY (id_answer);


--
-- TOC entry 2705 (class 2606 OID 16644)
-- Name: question question_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_pkey PRIMARY KEY (id_question);


--
-- TOC entry 2707 (class 2606 OID 16646)
-- Name: quiz quiz_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quiz
    ADD CONSTRAINT quiz_pkey PRIMARY KEY (id_quiz);


--
-- TOC entry 2709 (class 2606 OID 16648)
-- Name: score score_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.score
    ADD CONSTRAINT score_pkey PRIMARY KEY (id_score);


--
-- TOC entry 2710 (class 2606 OID 16649)
-- Name: answer id_question; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.answer
    ADD CONSTRAINT id_question FOREIGN KEY (id_question) REFERENCES public.question(id_question) ON UPDATE RESTRICT ON DELETE RESTRICT NOT VALID;


--
-- TOC entry 2712 (class 2606 OID 16654)
-- Name: score id_quiz; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.score
    ADD CONSTRAINT id_quiz FOREIGN KEY (id_quiz) REFERENCES public.quiz(id_quiz) NOT VALID;


--
-- TOC entry 2711 (class 2606 OID 16659)
-- Name: question id_quiz; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT id_quiz FOREIGN KEY (id_quiz) REFERENCES public.quiz(id_quiz) NOT VALID;


-- Completed on 2020-07-12 21:37:20

--
-- PostgreSQL database dump complete
--

