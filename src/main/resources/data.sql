INSERT INTO `rapport` (`id`, `bilan`, `date`, `motif`) VALUES
(2, 'J ai présenté le médicament HELICIDINE au généraliste, Monsieur Baturin, qui a une action sédative sur la toux. Il est utilisé dans le traitement symptomatique des toux sèches. Le praticien a paru être trés interessé. Je lui ai laissé 4 échantillons afin qu il puisse le tester J ai été agréablement de son retour et espére qu il sera un contact moteur pour l avenir. Cette visite est une totale réussite.', '2018-01-14', 'Ce praticien n a pas encore été visité'),
(3, 'J ai présenté notre nouveau médicament, HELICIDINE, au pneumologue, Monsieur Raphaelle, qui a une action sédative sur la toux. Il est utilisé dans le traitement symptomatique des toux sèches. Le praticien a paru septique. Je lui ai laissé 6 échantillons afin qu il puisse le tester et lui prouvé l efficacité de ce médicament. Son retour n a pas été bon, je lui ai dit que je le recontacterais dans 3 mois, le temps qu il teste le médicament et qu il puisse faire un prmeier retour. Cette visite a été délicate. Ce praticien n a pas encore été visité', '2020-10-22', 'Ce praticien ne connaissait pas notre nouveau médicament, l HELICIDINE'),
(5, 'J ai présenté notre médicament SPEDIFEN, au généraliste Monsieur Touffart. Ce médicament est un anti-inflammatoire non stéroïdien (AINS). Il lutte contre la douleur et fait baisser la fièvre. Ses propriétés anti-inflammatoires se manifestent à forte dose.\n\nIl est utilisé dans le traitement de courte durée de la fièvre et de la douleur (maux de tête, douleurs dentaires, courbatures, règles douloureuses...). Monsieur Touffart a semblé être trés intéressé par les résultats des études que je lui ai présenté. Je lui ai laissé 2 échantillons.', '2016-04-10', 'Quand j ai contacté ce praticien, il était demandeur d une rencontre.'),
(6, 'J ai présenté notre nouveau médicament l IXPRIM, à l infirmiére Madame Bichard qui officie à l hôpital conception. Traitement symptomatique des douleurs modérées à intenses. L utilisation d Ixprim doit être limitée aux patients dont la douleur modérée à intense nécessite un traitement par une association de paracétamol et de tramadol. Madame Bichard avait trés peu de temps et à l air débordée en cette période. en fin d entretin je lui ai promis de revenir la voir quand elle aura plus de disponibilité.', '2018-01-12', 'Premiére rencontre de cette praticienne. Permet d établir un contact'),
(7, 'J ai rencontré le docteur Mabuse qui est cardilogue à l hôpital bichat pour lui présenter notre médicament le DAFLON. Ce médicament est un veinotonique et un protecteur vasculaire. Il stimule la circulation du sang dans les veines et lutte contre l altération des vaisseaux capillaires. Le praticien a semblé trés intéressé par les études d impact que je lui ai présenté. Il avait des questions trés précise et semble être trés compétent dans son domaine', '2014-01-14', 'Praticien qui a une grande influence dans le milieur de la cardiologie');

INSERT INTO `user` (`login`, `active`, `password`) VALUES
('Coco', '1', 'Coucou_13'),
('Coco2', '1', 'Coucou2_13'),
('Coco3', '1', 'Coucou3_13'),
('Coco4', '1', 'Coucou4_13'),
('Coco5', '1', 'Coucou5_13'),
('Benji', '1', 'Coucou6_13');

INSERT INTO `user_role` (`id`, `login`, `role`) VALUES
(1, 'Coco', 'VIS'),
(4, 'Coco2', 'VIS'),
(8, 'Coco3', 'RC'),
(9, 'Coco4', 'RH'),
(10, 'Coco5', 'RH'),
(11, 'Benji', 'VIS');

INSERT INTO `utilisateur` (`type_uti`, `login`, `adresse`, `code_postal`, `date_embauche`, `date_naissance`, `nom`, `prenom`, `ville`) VALUES
('VIS', 'Coco', '108 bd de la valbarelle BT D5', 13011, '2021-04-20', '1995-07-23', 'ollive', 'cindy', 'Marseille'),
('VIS', 'Coco2', '108 bd de la valbarelle BT D4', 13012, '2021-04-20', '1995-07-25', 'ollive2', 'cindy2', 'Marseille'),
('RC', 'Coco3', '108 bd de la valbarelle BT D2', 13013, '2021-04-20', '1995-07-27', 'ollive3', 'cindy3', 'Marseille'),
('RH', 'Coco4', '108 bd de la valbarelle BT D1', 13014, '2021-04-20', '1995-07-31', 'ollive4', 'cindy4', 'Marseille'),
('RH', 'Coco5', '108 bd de la valbarelle BT D2', 13010, '2021-04-20', '1995-07-03', 'ollive5', 'cindy5', 'Marseille'),
('VIS', 'Benji', '108 bd de la valbarelle BT D5', 13011, '2021-04-20', '1995-07-23', 'Benjamin', 'desMarseillais', 'Marseille');

INSERT INTO `utilisateur_rapports` (`visiteur_login`, `rapports_id`) VALUES
('Coco', 2),
('Coco', 3),
('Coco2', 5),
('Coco2', 6),
('Coco2', 7);
COMMIT;