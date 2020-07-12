CREATE TABLE public."answer" (
    id_answer integer NOT NULL,
    text_answer "char",
    validity_answer boolean,
    id_question integer NOT NULL
);


ALTER TABLE public."answer" OWNER TO postgres;


CREATE SEQUENCE public."answer_id_answer_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."answer_id_answer_seq" OWNER TO postgres;



ALTER SEQUENCE public."answer_id_answer_seq" OWNED BY public."answer".id_answer;




CREATE SEQUENCE public."answer_id_question_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."answer_id_question_seq" OWNER TO postgres;



ALTER SEQUENCE public."answer_id_question_seq" OWNED BY public."answer".id_question;




CREATE TABLE public."question" (
    id_question integer NOT NULL,
    text_question "char",
    id_quiz integer NOT NULL
);


ALTER TABLE public."question" OWNER TO postgres;



CREATE SEQUENCE public."question_id_question_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."question_id_question_seq" OWNER TO postgres;



ALTER SEQUENCE public."question_id_question_seq" OWNED BY public."question".id_question;



CREATE SEQUENCE public."question_id_quiz_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."question_id_quiz_seq" OWNER TO postgres;



ALTER SEQUENCE public."question_id_quiz_seq" OWNED BY public."question".id_quiz;




CREATE TABLE public."quiz" (
    id_quiz integer NOT NULL,
    theme_quiz "char"
);


ALTER TABLE public."quiz" OWNER TO postgres;


CREATE TABLE public."score" (
    id_score integer NOT NULL,
    pseudo "char",
    final_score integer,
    "time" integer,
    date date,
    id_quiz integer NOT NULL
);


ALTER TABLE public."score" OWNER TO postgres;



CREATE SEQUENCE public."score_id_quiz_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."score_id_quiz_seq" OWNER TO postgres;


ALTER SEQUENCE public."score_id_quiz_seq" OWNED BY public."score".id_quiz;


CREATE SEQUENCE public."score_id_score_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."score_id_score_seq" OWNER TO postgres;

ALTER SEQUENCE public."score_id_score_seq" OWNED BY public."score".id_score;

ALTER TABLE ONLY public."answer" ALTER COLUMN id_answer SET DEFAULT nextval('public."answer_id_answer_seq"'::regclass);


ALTER TABLE ONLY public."answer" ALTER COLUMN id_question SET DEFAULT nextval('public."answer_id_question_seq"'::regclass);


ALTER TABLE ONLY public."question" ALTER COLUMN id_question SET DEFAULT nextval('public."question_id_question_seq"'::regclass);


ALTER TABLE ONLY public."question" ALTER COLUMN id_quiz SET DEFAULT nextval('public."question_id_quiz_seq"'::regclass);

ALTER TABLE ONLY public."score" ALTER COLUMN id_score SET DEFAULT nextval('public."score_id_score_seq"'::regclass);


ALTER TABLE ONLY public."score" ALTER COLUMN id_quiz SET DEFAULT nextval('public."score_id_quiz_seq"'::regclass);



ALTER TABLE ONLY public."answer"
    ADD CONSTRAINT "answer_pkey" PRIMARY KEY (id_answer);


ALTER TABLE ONLY public."question"
    ADD CONSTRAINT "question_pkey" PRIMARY KEY (id_question);

ALTER TABLE ONLY public."quiz"
    ADD CONSTRAINT "quiz_pkey" PRIMARY KEY (id_quiz);


ALTER TABLE ONLY public."score"
    ADD CONSTRAINT "score_pkey" PRIMARY KEY (id_score);


ALTER TABLE ONLY public."answer"
    ADD CONSTRAINT id_question FOREIGN KEY (id_question) REFERENCES public."question"(id_question) ON UPDATE RESTRICT ON DELETE RESTRICT NOT VALID;

ALTER TABLE ONLY public."score"
    ADD CONSTRAINT id_quiz FOREIGN KEY (id_quiz) REFERENCES public."quiz"(id_quiz) NOT VALID;


ALTER TABLE ONLY public."question"
    ADD CONSTRAINT id_quiz FOREIGN KEY (id_quiz) REFERENCES public."quiz"(id_quiz) NOT VALID;


