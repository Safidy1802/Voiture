create sequence user_seq start with 1 increment by 1; 
create table users(
    id varchar(60) primary key default 'USER'||nextval('user_seq'),
    nom varchar(150),
    prenom varchar(150),
    email varchar(150),
    role varchar(10),
    password varchar(150)
);

-- create table admin (
--     id serial primary key,
--     email varchar(150),
--     password varchar(150)
-- );

---gestion des éléments necessaires
create table categorie (
    id_categorie serial primary key,
    nom varchar(150)
);

create table marque (
    id serial primary key,
    nom varchar(150)
);

create table transmission(
    id serial primary key,
    nom varchar(150)
);

create table couleur (
    id serial primary key,
    nom varchar(150)
);

create table energie (
    id serial primary key,
    nom varchar(150)
);

create table pays (
    id serial primary key,
    nom varchar(150)
);

---gestion des annonces
create table voiture (
    id serial primary key,
    id_user varchar(60),
    id_marque integer,
    nom_model varchar(100),
    id_categorie integer,
    id_transmission integer,
    id_couleur integer,
    id_energie integer,
    id_pays integer,
    matricule varchar(100),
    annee integer,
    consommation float,
    reservoir float,
    nombre_place integer,
    kilometrage float,
    foreign key (id_user) references users(id),
    foreign key (id_marque) references marque(id),
    foreign key (id_categorie) references categorie(id_categorie),
    foreign key (id_transmission) references transmission(id),
    foreign key (id_couleur) references couleur(id),
    foreign key (id_energie) references energie(id),
    foreign key (id_pays) references pays(id)
);

create view v_voiture as
select v.id, u.id as id_user, marque.nom as marque, v.nom_model as model, c.nom_categorie as categorie, t.nom as transmission, cou.nom as couleur, e.nom as energie, p.nom as pays, v.matricule, v.annee, v.consommation, v.reservoir, v.nombre_place, v.kilometrage from voiture v
join users u on v.id_user=u.id
join categorie c on v.id_categorie=c.id_categorie
join marque on v.id_marque = marque.id;
join transmission t on v.id_transmission=t.id
join couleur cou on v.id_couleur=cou.id
join energie e on v.id_energie=e.id
join pays p on v.id_pays=p.id;


create table annonce (
    id serial primary key,
    id_voiture integer references voiture(id),
    prix float,
    descriptions text,
    date_annonce date default current_date,
    status integer,
    etat integer
);
--status 20 non vendu 30 vendu

create view v_voiture_annonce_details as
select annonce.id as id_annonce, v_voiture.*, annonce.prix, annonce.descriptions, annonce.date_annonce, annonce.status, annonce.etat from annonce
join v_voiture on annonce.id_voiture=v_voiture.id;

create table annonce_favoris (
    id serial primary key,
    id_user varchar(60) references users(id),
    id_annonce integer references annonce(id),
    date_ajout date default current_date
);

create view v_voiture_annonce_favoris as
select v_voiture_annonce_details.* from annonce_favoris 
join v_voiture_annonce_details on annonce_favoris.id_annonce=v_voiture_annonce_details.id_annonce;

CREATE table voiture_photo(
    id serial primary  key,
    id_voiture int references voiture(id),
    photo text
);

create view v_voiture_annonce_details_photo as
select v_voiture_annonce_details.*, voiture_photo.photo from v_voiture_annonce_details 
left join voiture_photo on v_voiture_annonce_details.id=voiture_photo.id_voiture;