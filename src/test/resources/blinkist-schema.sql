create table blinkist_user (
    user_id uuid,
    name varchar(50),
    email varchar(50) UNIQUE,
    password varchar(100),
    username varchar(30) UNIQUE,
    phone NUMERIC UNIQUE,
    is_active boolean,
    creation_date TIMESTAMP,
    is_admin boolean,
    PRIMARY KEY(user_id)
);

create table category(
    category_id UUID,
    category_name varchar(30),
    description varchar(100),
    PRIMARY KEY(category_id)

);

create table language(
    language_id UUID,
    language_name varchar(20),
    language_code varchar(5),
    is_active boolean,
    PRIMARY KEY(language_id)
);

create table book(
    book_id UUID,
    book_title varchar(50),
    creation_date DATE,
    author varchar(50),
    cover_image BYTEA,
    is_active boolean,
    language_id UUID,
    category_id UUID,
    number_of_reads INTEGER,
    total_read_time INTEGER,
    PRIMARY KEY(book_id),
    FOREIGN KEY(language_id)
        REFERENCES language(language_id),
    FOREIGN KEY(category_id)
        REFERENCES category(category_id)
);

create table blink(
    blink_id UUID,
    blink_title varchar(50),
    book_id UUID,
    blink_number INTEGER,
    blink_text varchar(2000),
    PRIMARY KEY(blink_id),
    FOREIGN KEY(book_id)
        REFERENCES book(book_id)
);

create table highlight(
    highlight_id UUID,
    user_id UUID,
    book_title varchar(50),
    blink_title varchar(50),
    blink_number INTEGER,
    highlight_text varchar(2000),
    creation_date DATE,
    PRIMARY KEY(highlight_id),
    FOREIGN KEY(user_id)
        REFERENCES blinkist_user(user_id)
)