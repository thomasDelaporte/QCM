
CREATE TABLE public."Answer" (
    id_answer integer NOT NULL,
    text_answer "char",
    validity_answer boolean,
    id_question integer NOT NULL
);


ALTER TABLE public."Answer" OWNER TO postgres;


CREATE SEQUENCE public."Answer_id_answer_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Answer_id_answer_seq" OWNER TO postgres;



ALTER SEQUENCE public."Answer_id_answer_seq" OWNED BY public."Answer".id_answer;




CREATE SEQUENCE public."Answer_id_question_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Answer_id_question_seq" OWNER TO postgres;



ALTER SEQUENCE public."Answer_id_question_seq" OWNED BY public."Answer".id_question;




CREATE TABLE public."Question" (
    id_question integer NOT NULL,
    text_question "char",
    id_quiz integer NOT NULL
);


ALTER TABLE public."Question" OWNER TO postgres;



CREATE SEQUENCE public."Question_id_question_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Question_id_question_seq" OWNER TO postgres;



ALTER SEQUENCE public."Question_id_question_seq" OWNED BY public."Question".id_question;



CREATE SEQUENCE public."Question_id_quiz_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Question_id_quiz_seq" OWNER TO postgres;



ALTER SEQUENCE public."Question_id_quiz_seq" OWNED BY public."Question".id_quiz;




CREATE TABLE public."Quiz" (
    id_quiz integer NOT NULL,
    theme_quiz "char"
);


ALTER TABLE public."Quiz" OWNER TO postgres;


CREATE TABLE public."Score" (
    id_score integer NOT NULL,
    pseudo "char",
    final_score integer,
    "time" integer,
    date date,
    id_quiz integer NOT NULL
);


ALTER TABLE public."Score" OWNER TO postgres;



CREATE SEQUENCE public."Score_id_quiz_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Score_id_quiz_seq" OWNER TO postgres;


ALTER SEQUENCE public."Score_id_quiz_seq" OWNED BY public."Score".id_quiz;


CREATE SEQUENCE public."Score_id_score_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Score_id_score_seq" OWNER TO postgres;

ALTER SEQUENCE public."Score_id_score_seq" OWNED BY public."Score".id_score;

ALTER TABLE ONLY public."Answer" ALTER COLUMN id_answer SET DEFAULT nextval('public."Answer_id_answer_seq"'::regclass);


ALTER TABLE ONLY public."Answer" ALTER COLUMN id_question SET DEFAULT nextval('public."Answer_id_question_seq"'::regclass);


ALTER TABLE ONLY public."Question" ALTER COLUMN id_question SET DEFAULT nextval('public."Question_id_question_seq"'::regclass);


ALTER TABLE ONLY public."Question" ALTER COLUMN id_quiz SET DEFAULT nextval('public."Question_id_quiz_seq"'::regclass);

ALTER TABLE ONLY public."Score" ALTER COLUMN id_score SET DEFAULT nextval('public."Score_id_score_seq"'::regclass);


ALTER TABLE ONLY public."Score" ALTER COLUMN id_quiz SET DEFAULT nextval('public."Score_id_quiz_seq"'::regclass);



ALTER TABLE ONLY public."Answer"
    ADD CONSTRAINT "Answer_pkey" PRIMARY KEY (id_answer);


ALTER TABLE ONLY public."Question"
    ADD CONSTRAINT "Question_pkey" PRIMARY KEY (id_question);

ALTER TABLE ONLY public."Quiz"
    ADD CONSTRAINT "Quiz_pkey" PRIMARY KEY (id_quiz);


ALTER TABLE ONLY public."Score"
    ADD CONSTRAINT "Score_pkey" PRIMARY KEY (id_score);


ALTER TABLE ONLY public."Answer"
    ADD CONSTRAINT id_question FOREIGN KEY (id_question) REFERENCES public."Question"(id_question) ON UPDATE RESTRICT ON DELETE RESTRICT NOT VALID;

ALTER TABLE ONLY public."Score"
    ADD CONSTRAINT id_quiz FOREIGN KEY (id_quiz) REFERENCES public."Quiz"(id_quiz) NOT VALID;


ALTER TABLE ONLY public."Question"
    ADD CONSTRAINT id_quiz FOREIGN KEY (id_quiz) REFERENCES public."Quiz"(id_quiz) NOT VALID;


