package com.example.carrace

object CatRepository {
    val cats: List<Cat> = listOf(
        Cat(
            id = 1,
            name = "bengal",
            shortDescription = "medium hair, energetic and lively <3",
            longDescription = "incredibly beautiful animals that combine the spectacular appearance " +
                    "of wild predators and the docile nature of pets. well, the main \"feature\" of " +
                    "these creatures is the \"leopard color\", for which they are called \"domestic leopards\"",
            imageUrl = "https://www.proplan.ru/sites/default/files/breeders/%D0%B1%D0%B5%D0%BD%D0%B3%D0%B0%D0%BB%D1%8C%D1%81%D0%BA%D0%B0%D1%8F%20%D0%BA%D0%BE%D1%88%D0%BA%D0%B0%202-min.jpg"
        ),
        Cat(
            id = 2,
            name = "maine coon",
            shortDescription = "big-cat with long-hair, smart and gentle",
            longDescription = "one of the most amazing and mysterious breeds is considered to be the " +
                    "maine coon - an affectionate giant with a serious look. these creatures are called " +
                    "\"indoor lynxes\", which is not surprising, because they are one of the largest domestic cats",
            imageUrl = "https://furman.top/uploads/posts/2023-11/1700726847_furman-top-p-meinkun-kot-oboi-pinterest-31.jpg"
        ),
        Cat(
            id = 3,
            name = "sphynx",
            shortDescription = "bald :) very quite and loyal",
            longDescription = "representatives of this breed are a \"miracle of nature\": they really" +
                    " have something mysterious and fascinating. they are also called \"bald cats\" – " +
                    "not everyone likes their appearance, but there is also a positive point – they never shed",
            imageUrl = "https://douo.ru/wp-content/uploads/2023/08/koty-sfinksy-1-1.webp"
        ),
        Cat(
            id = 4,
            name = "oriental",
            shortDescription = "short hair&big ears, intelligent&playful",
            longDescription = "do you remember cheburashka? if you forgot,then at the first glance at " +
                    "an oriental cat, this creature will come to mind: huge ears and big eyes made " +
                    "this breed popular and beloved. add to this the devoted love for the owners – " +
                    "and you will understand that it is difficult to find a better pet",
            imageUrl = "https://ornella.club/uploads/posts/2023-05/1685093227_ornella-club-p-orientalnie-koti-krasivo-14.jpg"
        ),
        Cat(
            id = 5,
            name = "manchkin",
            shortDescription = "pretty small cat, agile and intelligent",
            longDescription = "munchkin is a cat that attracts attention with an unusual appearance. " +
                    "this breed is very popular among cat breeders because it has a meek, docile and very " +
                    "\"accommodating\" character. yes, there's nothing to be modest about – they're just \"charmers\"! " +
                    "and that's why their owners like them",
            imageUrl = "https://pipcat.ru/wp-content/uploads/2022/09/%D0%9C%D0%B0%D0%BD%D1%87%D0%BA%D0%B8%D0%BD.jpg"
        ),
        Cat(
            id = 6,
            name = "ragdoll",
            shortDescription = "semi-long hair, friendly and gentle",
            longDescription = "if you see a huge cat with a fluffy tail, then most likely you " +
                    "will see a ragdoll in front of you. when you take a pet in your arms, it " +
                    "relaxes the muscles, and hangs down \"like a rag\" (this is not a disease or paralysis, " +
                    "but a feature of the breed)",
            imageUrl = "https://gorodprizrak.com/wp-content/uploads/2022/03/115350299816613019-medialibrary_original.jpg"
        ),
        Cat(
            id = 7,
            name = "persian",
            shortDescription = "long&silky hair, loyal and sedate",
            longDescription = "\"persians\" are one of the most popular breeds in the world for many " +
                    "decades, they are the leaders of all exhibitions and ratings, as well as one of " +
                    "the most famous breeds with a mysterious history, exotic appearance and calm disposition",
            imageUrl = "https://www.funnyart.club/uploads/posts/2022-12/1671812849_www-funnyart-club-p-persidskaya-koshka-belaya-estetichno-1.jpg"
        ),
    )

    fun getCatById(catId: Int): Cat? {
        return cats.find { it.id == catId }
    }
}