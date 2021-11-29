package com.data;

import com.tree.Tree;
import com.tree.TreeDAO;
import com.user.User;
import com.user.UserDAO;

public class hiddenData {
    public static void doRoot()
    {
        User admin1 = new User();
        User admin2 = new User();
        User admin3 = new User();
        User admin4 = new User();
        User admin5 = new User();

        admin1.setEmail("admin");
        admin2.setEmail("cpea");
        admin3.setEmail("tinBeo");
        admin4.setEmail("tphat");
        admin5.setEmail("tthien");
        
        admin1.setAdmin(1);
        admin2.setAdmin(1);
        admin3.setAdmin(1);
        admin4.setAdmin(1);
        admin5.setAdmin(1);

        admin1.setPass("123456789aA");
        admin2.setPass("123456789aA");
        admin3.setPass("123456789aA");
        admin4.setPass("123456789aA");
        admin5.setPass("123456789aA");

        UserDAO.addUser(admin1);
        UserDAO.addUser(admin2);
        UserDAO.addUser(admin3);
        UserDAO.addUser(admin4);
        UserDAO.addUser(admin5);

    }

    public static void postItem()
{
    String[]imgStrings={
        "https://image1.jdomni.in/product/13072018/B7/C0/4D/9D5C3F4C01885F12D2C31B3F34_1531485148061.jpg?fit=around|1024:768",
        "https://image1.jdomni.in/product/13072018/53/87/0C/E74C0CE1D76D1545C3CC6E6CC8_1531485165651.jpg?fit=around|235:235",
        "https://image1.jdomni.in/product/13072018/BE/8E/56/90B397914E2047070997AB1385_1531485154638.jpg?fit=around|1024:768",
        "https://image1.jdomni.in/product/13072018/A2/0A/94/86391F55B1D8B9B7AB81088534_1531485150980.jpg?fit=around|235:235",
        "https://image1.jdomni.in/product/13072018/DF/FE/9A/218373B7D3BEDA5A66ADF84AFD_1531485168335.jpeg?fit=around|1024:768",
        "https://image1.jdomni.in/product/05012018/83/FF/4A/683920B3D98E5F43941DB332FA_1515169978935.jpg?fit=around|1024:768",
        "https://image1.jdomni.in/product/13072018/A7/6E/20/82EA9C97A49CCCB824F1DB2812_1531485157964.jpg?fit=around|1024:768",
        
        "https://image1.jdomni.in/product/20102020/4E/D5/EA/236C4F0A920A5C4FA57E038122_1603214277084.jpg?fit=around|1024:768",
        "https://image1.jdomni.in/product/20102020/2A/5B/10/BC6832BF54C37DAD3BDDEFE883_1603214273448.jpg?fit=around|1024:768",
        "https://image1.jdomni.in/product/20102020/39/B9/1B/4E7336F86019FCFD743E58D17F_1603214270099.jpg?fit=around|1024:768",
        "https://image1.jdomni.in/product/20102020/43/19/14/EC8251D4ECED9F6EC148545612_1603214268529.jpg?fit=around|1024:768",
        "https://image1.jdomni.in/product/20102020/20/DF/61/F93E1A5A61B0DED01BB507BE7B_1603214266052.jpg?fit=around|1024:768",
        
        "https://image1.jdomni.in/product/13072018/25/DF/BA/30D4E12F83074A3458C8069D5F_1531485259048.jpg?fit=around|1024:768",
        "https://image1.jdomni.in/product/13072018/9F/3B/FD/99BF95F3B3F626C8B14FF6D19C_1531485256922.jpg?fit=around|1024:768",
        "https://image1.jdomni.in/product/13072018/DC/BD/19/139E377B204A601C1421F4D56C_1531485253782.jpg?fit=around|1024:768",
        "https://image1.jdomni.in/product/13072018/EB/51/C5/B6CF3F703E1B8AD3E1B0D0B197_1531485250303.jpg",
        "https://image1.jdomni.in/product/13072018/A6/69/CE/9E42FD0294F80CDD6563BFB8FE_1531485246917.jpg",
        "https://image1.jdomni.in/product/13072018/6A/46/D8/4D7139566B37384D985C13A725_1531485243759.jpg",
        "https://image1.jdomni.in/product/13072018/75/16/BD/A8F3E2AE4F21B50CD11F6981A4_1531485240760.jpg",
        "https://image1.jdomni.in/product/13072018/6A/E0/E4/471ABED9390D3E5B955ECAEA21_1531485238103.jpg",
        
        "https://image1.jdomni.in/product/13072018/A1/8E/79/4B2C6976FE240F3F3B26899453_1531485225778.jpg?fit=around|1024:768",
        "https://image1.jdomni.in/product/13072018/A0/A2/25/742B17844E07224A33FA0E817E_1531485232579.jpg",
        "https://image1.jdomni.in/product/13072018/C9/6D/45/2BDD493BB4E20EDD0DCE0FFE75_1531485230371.jpg",
        "https://image1.jdomni.in/product/13072018/A1/8E/79/4B2C6976FE240F3F3B26899453_1531485225778.jpg",
        "https://image1.jdomni.in/product/13072018/DA/43/17/F6294986C1EB9F033021755A76_1531485222560.jpg",
        "https://image1.jdomni.in/product/13072018/36/2C/D1/857A3E0E886D92CAADE00F6079_1531485214550.jpg",
        "https://image1.jdomni.in/product/13072018/5C/ED/47/6E1036CBD469C6F62813FBB361_1531485207427.jpg",
        "https://image1.jdomni.in/product/13072018/F2/AA/2D/806F847144EE3739F9CF86BA25_1531485201873.jpg",

        "https://image1.jdomni.in/product/13072018/06/72/00/F4F4290B9D52A34474494BBBC7_1531485194412.jpg",
        "https://image1.jdomni.in/product/13072018/1B/B9/AD/2EA4CDDDE37BFD3A5C73A8AA6F_1531485191576.jpeg",
        "https://image1.jdomni.in/product/13072018/E8/BA/F8/6BC4A25C61E2BB53A411D70500_1531485187401.jpg",
        "https://image1.jdomni.in/product/13072018/E8/39/11/47E81DE08369BBBBFF33C8145F_1531485184131.jpeg",
        "https://image1.jdomni.in/product/13072018/01/3A/61/6C01A38907E61C580253027294_1531485181308.jpg",
        "https://image1.jdomni.in/product/13072018/C5/53/E5/1C276462B28A443DEB360EE615_1531485178401.jpg",
        "https://image1.jdomni.in/product/13072018/2C/1B/EF/119AFC465847A48305882612F6_1531485174326.jpg",
        "https://image1.jdomni.in/product/13072018/38/84/A9/57680BB0DA25AFDC800433E526_1531485171970.jpg",
    };

    String[]treeName={
        "Bonsai Wild Plant With Pot",
        "Bonsai Tree With Wooden Pot",
        "GoodLuck Bonsai Plant",
        "Bonsai Plant With Melamine Pot",
        "Japanese Bonsai Green Maple Tree",
        "Bonsai Wild Artificial Plant With Pot",
        "Bonsai Wild Plant",
        
        "ZZ Plant, Zamia Air Purifer Plant With Self Watering Pot",
        "Air Purifying Bamboo Palm Plant With Self Watering Pot",
        "Good Luck Air Purifying Pink Syngonium Plant In Black Ceramic Pot",
        "ZZ Indoor Air Purifying Plant With Plastic Pot",
        "Air Purifying Spider Plant In Smiley Cup",
        
        "Lively Plant",
        "Microdasys Plant",
        "Zebrina Plant",
        "Chamaecereus Plant",
        "Cactus",
        "Ear Cactus",
        "Echeverione Succulent Garden Potted Flower",
        "Fantastic Jade Terrarium",
        
        "Live Madhumalati Honeysuckle Rangoon",
        "Morning Glory Red",
        "Nasturtium Climber Flower Plant",
        "Live Madhumalati Honeysuckle Rangoon",
        "Henryana",
        "Complexa",
        "Officinale",
        "Formosa",

        "Plants",
        "Petunia Flowering Plant",
        "Tagar Plant",
        "Miniature Flower Plant",
        "Flower Plant",
        "Plant",
        "Flowering Plants",
        "Orchild Plant"
    };

    String[]treeKind={
        "Bonsai",
        "Bonsai",
        "Bonsai",
        "Bonsai",
        "Bonsai",
        "Bonsai",
        "Bonsai",

        "Air Purifying Plant",
        "Air Purifying Plant",
        "Air Purifying Plant",
        "Air Purifying Plant",
        "Air Purifying Plant",

        "Cactus & Succulents",
        "Cactus & Succulents",
        "Cactus & Succulents",
        "Cactus & Succulents",
        "Cactus & Succulents",
        "Cactus & Succulents",
        "Cactus & Succulents",
        "Cactus & Succulents",

        "Climbers & Creepers",
        "Climbers & Creepers",
        "Climbers & Creepers",
        "Climbers & Creepers",
        "Climbers & Creepers",
        "Climbers & Creepers",
        "Climbers & Creepers",
        "Climbers & Creepers",

        "Flowering",
        "Flowering",
        "Flowering",
        "Flowering",
        "Flowering",
        "Flowering",
        "Flowering",
        "Flowering",

    };

    String[]treeBrand={
        "Hyperboles",
        "Hyperboles",
        "Fourwalls",
        "GoodLuck Greenz",
        "Priyathams",
        "Splenor",
        "Miracle",

        "Ugaoo",
        "Ugaoo",
        "Rolling Nature",
        "CAPPL",
        "Rolling Nature",

        "Jade",
        "Opuntia",
        "Huernia",
        "Echinopsis",
        "Columnar",
        "Bunny",
        "Egrow",
        "Terrarium",

        "Nelesa Gardening",
        "Seedscare",
        "Creative Farmer",
        "Nelesa Gardening",
        "Parthenocissus",
        "Muehlenbeckia",
        "Jasminum",
        "Wisteria",

        "Pink",
        "Pink",
        "Variegated",
        "Tagar",
        "Bougainvillea",
        "Chafa",
        "Pink",
        "Orchid",

    };

    String[]treeDescription={
        "Bonsai is a Japanese version of the original tradiational, which utilizes traditional techniques to produce entire natural sceneries in small pots that mimic the grandiose and shape of real life sceneries",
        "It normally have a big leaf, with green color suitable for grow at the entry",
        " plants with parts that are thickened, fleshy, and engorged, usually to retain water in arid climates or soil conditions. It is a characteristic that is not used scientifically for the definition of most families and genera of plants because it often can be used as an accurate characteristic only at the single species level",
        "Climber is any plant with a growth habit of trailing or scandent (that is, climbing) stems, lianas or runners. The word vine can also refer to such stems or runners themselves, for instance, when used in wicker work",
        "It smell really good help you relax after day work hard day",
    };

    int[]treePrice={
        200,
        300,
        425,
        499,
        482,
        399,
        999,

        459,
        422,
        339,
        229,
        400,

        299,
        349,
        249,
        399,
        299,
        200,
        180,
        249,

        269,
        250,
        399,
        299,
        440,
        500,
        330,
        250,

        299,
        750,
        750,
        300,
        999,
        650,
        350,
        300,




    };

    int quality = 10;
    for(int i = 0 ; i < imgStrings.length ; i++)
    {
        Tree tree = new Tree();
        tree.setAmount(quality);
        tree.setPrice(treePrice[i]);
        tree.setTreeBrand(treeBrand[i]);
        tree.setTreeImg(imgStrings[i]);
        tree.setTreeKind(treeKind[i]);
        tree.setTreeName(treeName[i]);
        if(tree.getTreeKind().equals("Bonsai"))
        {
            tree.setTreeDescription(treeDescription[0]);
        }
        else if (tree.getTreeKind().equals("Air Purifying Plant"))
        {
            tree.setTreeDescription(treeDescription[1]);

        }
        else if (tree.getTreeKind().equals("Cactus & Succulents"))
        {
            tree.setTreeDescription(treeDescription[2]);
            
        }
        else if (tree.getTreeKind().equals("Climbers & Creepers"))
        {
            tree.setTreeDescription(treeDescription[3]);
        }
        else if (tree.getTreeKind().equals("Flowering"))
        {
            tree.setTreeDescription(treeDescription[4]);
        }
        TreeDAO.addTree(tree);
    }


}
}
