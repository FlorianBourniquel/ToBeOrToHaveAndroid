package com.example.florian.tobeortohave.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Database {
    private static Database instance = null;
    private List<Category> categories = new LinkedList<>();
    private List<Product> products = new LinkedList<>();
    private User user;

    public Database() {
        Product product = new Product("https://images-na.ssl-images-amazon.com/images/I/618suxK%2BZbL._SL1000_.jpg","Tapis de Yoga",15.00, "L'épaisseur de 5 mm offre un bon amortissement pour tous les exercices au sol\n\n" +
                "Matériau : matières synthétiques (PVC) respectueuses de l'environnement, ni phtalates (plastifiants), ni colorants azoïques ou métaux lourds\n\n" +
                "Assorti à la couleur des coussins de méditation et de yoga Lotuscrafts\n\n" +
                "Dimensions : 183 x 60 x 0,5 cm, poids : env. 1,2 kg","Tapis de yoga d'usage universel pour pratique en studio");

        Product product2 = new Product("https://images-na.ssl-images-amazon.com/images/I/61R1B8UG2-L.jpg","12 huiles essentielles",40.00,0.50,"Basilic, Citron, Citronnelle, Cèdre Atlas, Eucalyptus Globulus, Lavandin, Menthe, Orange, Pin Sylvestre, Romarin, Arbre à thé (Tea-Tree) et Ylang-Ylang. \n\n" +
                "Idéal pour soins aromathérapie et diffusion. Qualité controlée France\n\n" +
                "Huiles Essentielles 100% pures et naturelles chemotypée HEBBD - Non diluée - Qualité Thérapeutique - Vegan non testées sur les animaux\n\n" +
                "Flacon verre brun avec bouchon goutte a goutte :hauteur 6,3 cm / diametre : 2,5 cm Convient pour coffret de rangement Aromathèque en bois de rose et de palissandre des Indes","Lot de 12 huiles essentielles 10ml 100% pures et naturelles.");

        List<Product> products = new LinkedList<>();

        products.add(product);
        this.products.add(product);
        products.add(product2);
        this.products.add(product2);

        Product product3 = new Product("https://images-na.ssl-images-amazon.com/images/I/71w6RQr75JL._SL1200_.jpg","Globe Teresstre Lévitation",153.00,0.55,"Suspension pneumatique couleur lumineuse, l'ameublement, cadeaux pour partager, des impressions publicitaires.\n\n" +
                "Globe Taille: 6 pouces, Hauteur de Suspension: 2cm, Taille du Châssis: 18cmX18cmX5cm\n\n" +
                "Attributs facultatifs du produit: EU plug, Puissance: 12V, 1500mA, moins de 1.5W","Globe Teresstre Lévitation");

        Product product4 = new Product("https://images-na.ssl-images-amazon.com/images/I/316LhJiBanL.jpg","Hand Spiner",12.00,"Tient dans la poche, s'emmène partout\n\n" +
                "Rapide (largement plus de deux minute de roulement en fonction de la force donnée au départ)\n\n" +
                "Apaisant, anti-stress\n\n" +
                "Roulement haute performance en acier de grande qualité et sans bruit\n\n" +
                "Coque en plastique PVC ultra solide, ne casse pas en tombant au sol","Hand Spiner Blanc");

        Product product5 = new Product("https://images-na.ssl-images-amazon.com/images/I/41O6cYq9HoL.jpg","Cube Gadget",38.00,0.55,"QUALITÉ : Objet conçu pour une durée de vie prolongée. Fabriqué avec des matériaux solides contrôlés.\n\n" +
                "DESIGN : Gadget / Fidget au design bien pensé, à transporter facilement dans sa poche. Dimensions : 3cm x 3cm x 3cm / Poids : 40g\n\n" +
                "DÉSTRESSANT : Objet indispensable pour tous les stressés des doigts. Pour un cadeau ou pour soi-même !\n\n" +
                "GARANTIE & SAV : Garantie Satisfait ou Remboursé de 30 jours - Equipe française à votre écoute pour toutes questions/remarques\n\n" +
                "Livraison rapide et soignée", "Cube Gadget Noir");

        Product product6 = new Product("https://images-na.ssl-images-amazon.com/images/I/51gkSrv0b6L.jpg","Abyss",36.00,"Depuis des siècles, les atlantes règnent sur les profondeurs des océans. Leur royaume, abysse, est respecté de tous les peuples alliés, heureux d’y trouver une protection contre les redoutables monstres sous-marins. Bientôt, le trône atlante sera libre. Pour y accéder, fédérez les meilleurs représentants des peuples alliés, recrutez des seigneurs atlantes et contrôlez les principaux territoires du royaume.","Jeu de Strategie - Abyss");

        List<Product> products2 = new LinkedList<>();

        products2.add(product3);
        this.products.add(product3);
        products2.add(product4);
        this.products.add(product4);
        products2.add(product5);
        this.products.add(product5);
        products2.add(product6);
        this.products.add(product6);


        Product product7 = new Product("https://images-na.ssl-images-amazon.com/images/I/71L5KTza1oL._SL1200_.jpg","Gladiator",15.00,"Disque : 1\n" +
                "  1. - progeny\n" +
                "  2. - the wheat\n" +
                "  3. - the battle\n" +
                "  4. - earth\n" +
                "  5. - sorrow\n" +
                "  6. - to zuccabar\n" +
                "  7. - patricide\n" +
                "  8. - the emperor is dead\n" +
                "  9. - the might of rome\n" +
                "  10. - strength and honor\n" +
                "\n" +
                "Disque : 2\n" +
                "  1. - reunion - Hans Zimmer\n" +
                "  2. - slaves to rome\n" +
                "  3. - barbarian mode - Hans Zimmer\n" +
                "  4. - am I not merciful? - Hans Zimmer\n" +
                "  5. - elysium\n" +
                "  6. - honor him - Hans Zimmer\n" +
                "  7. - now we are free - Hans Zimmer", "Vinyles de la bande originale du film Gladiator");

        Product product8 = new Product("https://images-na.ssl-images-amazon.com/images/I/81ZmiF-9-2L._SL1200_.jpg","Guardians of the Galaxy",15.00,0.20,"\t\n" +
                " 1. - Hooked On A Feeling - de Blue Swede\n" +
                " 2. - Go All The Way - de The Raspberries\n" +
                " 3. - Spirit In The Sky - de Norman Greenbaum\n" +
                " 4. - Moonage Daydream - de David Bowie\n" +
                " 6. - Fooled Around And Fell In Love - de Elvin Bishop\n" +
                " 7. - I'm Not In Love - de 10cc\n" +
                " 8. - I Want You Back - de Jackson 5\n" +
                " 9. - Come And Get Your Love - de Redbone\n" +
                " 10. - Cherry Bomb - de The Runaways\n" +
                " 11. - Escape (The Pina Colada Song) - de Rupert Holmes\n" +
                " 12. - Child - de The Five Stairsteps\n", "Vinyles de la bande originale du film Les Gardiens de la galaxie");

        List<Product> products3 = new LinkedList<>();

        products3.add(product7);
        this.products.add(product7);
        products3.add(product8);
        this.products.add(product8);

        categories.add(new Category(products, "http://www.merignac.com/sites/default/files/large-bien-etre.jpg", "Sante et Bien être"));
        categories.add(new Category(products2, "http://achatventeacheterpascher.fr/jouet/jouets-bebe-occasions.jpg", "Jouets"));
        categories.add(new Category(products3, "http://waxbuyers.club/wp-content/uploads/2016/01/Vinyle-1200x480.jpg", "Vinyles"));
        categories.add(new Category(new LinkedList<Product>(), "http://icons.iconarchive.com/icons/fps.hu/free-christmas-flat-circle/512/star-icon.png", "Mes Favoris"));
        user = new User();
    }

    public static Database getInstance() {
        if (null == instance) {
            instance = new Database();
        }
        return instance;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Product> getProductsByCategoriesNameSortByName(String name) {
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                List<Product> products = category.getProducts();
                Collections.sort(products, Product.ProductNameComparator);
                return products;
            }
        }
        return null;
    }

    public List<Product> getProductsByCategoriesNameSortByPrice(String name) {
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                List<Product> products = category.getProducts();
                Collections.sort(products, Product.ProductPriceComparator);
                return products;
            }
        }
        return null;
    }

    public Product getProductsByName(String productName) {
        for (Product product: products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }
}
