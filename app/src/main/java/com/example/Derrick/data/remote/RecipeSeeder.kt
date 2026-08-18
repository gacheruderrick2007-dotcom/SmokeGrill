package com.example.Derrick.data.remote

import com.example.Derrick.data.model.Recipe
import com.example.Derrick.data.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object RecipeSeeder {
    private val repository = RecipeRepository()

    val kenyanRecipes = listOf(
        Recipe(
            title = "Ugali Sukuma Wiki & Eggs",
            description = "A staple budget-friendly meal for many Kenyan youths. Quick to prepare and very filling.",
            imageUrl = "https://images.unsplash.com/photo-1606787366850-de6330128bfc",
            ingredients = listOf(
                "2 cups Maize Flour",
                "1 bunch Sukuma Wiki (Kale)",
                "2 Eggs",
                "1 Onion",
                "2 Tomatoes",
                "Cooking Oil",
                "Salt"
            ),
            instructions = listOf(
                "Boil 3 cups of water in a pot.",
                "Gradually add maize flour while stirring until thick. Cover and let cook for 5-10 mins to make Ugali.",
                "Heat oil in a pan, fry chopped onions until golden.",
                "Add tomatoes and cook until soft. Add chopped sukuma wiki and salt. Stir and cook for 5 mins.",
                "In another pan, fry the eggs (scrambled or sunny side up).",
                "Serve the Ugali hot with Sukuma Wiki and Eggs."
            ),
            estimatedCost = 150,
            webUrl = null,
            category = "Budget Friendly"
        ),
        Recipe(
            title = "Chapati & Dondo (Yellow Beans)",
            description = "The ultimate 'mtaani' favorite. Soft chapatis paired with tasty fried beans.",
            imageUrl = "https://images.unsplash.com/photo-1589187151003-fb66cc3ad17f",
            ingredients = listOf(
                "3 cups Wheat Flour",
                "2 cups Cooked Yellow Beans (Dondo)",
                "1 Onion",
                "2 Tomatoes",
                "Garlic/Ginger paste",
                "Cooking Oil",
                "Salt and Sugar"
            ),
            instructions = listOf(
                "Make chapati dough with flour, water, salt, sugar, and oil. Roll and fry on a pan until golden brown.",
                "For the beans: Fry onions in a pot until soft.",
                "Add garlic/ginger paste and tomatoes. Cook until tomatoes form a paste.",
                "Add the pre-cooked yellow beans and a little water for soup.",
                "Simmer for 10 minutes. Serve hot with the chapatis."
            ),
            estimatedCost = 250,
            webUrl = null,
            category = "Popular"
        ),
        Recipe(
            title = "Smokie Pasua with Kachumbari",
            description = "The most popular Kenyan street food. Quick, spicy, and delicious.",
            imageUrl = "https://images.unsplash.com/photo-1599487488170-d11ec9c173f0",
            ingredients = listOf(
                "4 Smokie sausages",
                "1 Onion",
                "2 Tomatoes",
                "Dania (Coriander)",
                "Green Chilies (optional)",
                "Tomato Sauce/Chili Sauce"
            ),
            instructions = listOf(
                "Deep fry or grill the smokies until heated through and slightly crispy.",
                "Prepare Kachumbari: Finely chop onions, tomatoes, dania, and chilies. Mix in a bowl with a pinch of salt.",
                "Slice each smokie lengthwise (pasua) but not all the way through.",
                "Stuff the smokie with a generous amount of kachumbari.",
                "Add tomato or chili sauce as desired and enjoy."
            ),
            estimatedCost = 120,
            webUrl = null,
            category = "Quick Meals"
        ),
        Recipe(
            title = "Githeri (Special)",
            description = "A mixture of maize and beans, elevated with vegetables for a hearty meal.",
            imageUrl = "https://images.unsplash.com/photo-1547592166-23ac45744acd",
            ingredients = listOf(
                "2 cups Pre-boiled Maize and Beans",
                "2 Potatoes (peeled and cubed)",
                "1 Onion",
                "2 Tomatoes",
                "Carrots (chopped)",
                "Capsicum (Hoho)",
                "Salt and spices (Beef masala)"
            ),
            instructions = listOf(
                "Fry onions and hoho until fragrant.",
                "Add tomatoes, carrots, and potatoes. Cook until tomatoes are soft.",
                "Add the pre-boiled maize and beans (githeri).",
                "Add a cup of water, salt, and beef masala spices.",
                "Cover and let it simmer until potatoes are well cooked and the soup thickens.",
                "Serve hot."
            ),
            estimatedCost = 200,
            webUrl = null,
            category = "Traditional"
        ),
         Recipe(
            title = "Pilau (Kienyeji Style)",
            description = "Fragrant rice cooked with beef and traditional pilau spices.",
            imageUrl = "https://images.unsplash.com/photo-1512058560366-cd2429598642",
            ingredients = listOf(
                "2 cups Rice",
                "500g Beef (cubed)",
                "2 Onions (large)",
                "3 cloves Garlic",
                "1 piece Ginger",
                "Pilau Masala",
                "Cooking Oil"
            ),
            instructions = listOf(
                "Boil beef until tender.",
                "Fry onions until dark brown (this gives Pilau its color).",
                "Add crushed garlic and ginger, then the pilau masala.",
                "Add the boiled beef and stir for 2 minutes.",
                "Add rice and 4 cups of water/beef broth.",
                "Cook on low heat until water is absorbed. Serve with Kachumbari."
            ),
            estimatedCost = 450,
            webUrl = null,
            category = "Special"
        ),
        Recipe(
            title = "Nyama Choma & Kachumbari",
            description = "The classic Kenyan grilled meat experience, usually enjoyed with friends and family.",
            imageUrl = "https://images.unsplash.com/photo-1555939594-58d7cb561ad1",
            ingredients = listOf(
                "1kg Goat or Beef ribs",
                "Salt",
                "1 Onion",
                "2 Tomatoes",
                "Coriander",
                "Lemon"
            ),
            instructions = listOf(
                "Rub the meat with salt.",
                "Grill over charcoal for 30-45 minutes, turning occasionally until browned and cooked through.",
                "Prepare Kachumbari by mixing chopped onions, tomatoes, and coriander with lemon juice.",
                "Slice the meat into bite-sized pieces and serve with Ugali and Kachumbari."
            ),
            estimatedCost = 800,
            webUrl = null,
            category = "Traditional"
        ),
        Recipe(
            title = "Mukimo",
            description = "A nutritious mash of potatoes, maize, beans, and pumpkin leaves or stinging nettle.",
            imageUrl = "https://images.unsplash.com/photo-1543339308-43e59d6b73a6",
            ingredients = listOf(
                "1kg Potatoes",
                "2 cups Maize (soft)",
                "1 cup Beans or Peas",
                "1 bunch Pumpkin leaves (Managu) or Stinging Nettle",
                "1 Onion",
                "Cooking Oil",
                "Salt"
            ),
            instructions = listOf(
                "Boil maize and beans/peas until soft.",
                "Peel and boil potatoes in a separate pot with the pumpkin leaves on top.",
                "Once potatoes are soft, drain water (keep a little) and mash together with the leaves.",
                "Add the boiled maize and beans to the mash and mix well.",
                "Fry onions in oil until golden and stir into the Mukimo.",
                "Serve with beef stew or Kachumbari."
            ),
            estimatedCost = 350,
            webUrl = null,
            category = "Traditional"
        ),
        Recipe(
            title = "Matoke ya Nyama",
            description = "Delicious green bananas stewed with beef and vegetables.",
            imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd",
            ingredients = listOf(
                "10 Green Bananas (Matoke)",
                "500g Beef (cubed)",
                "1 Onion",
                "2 Tomatoes",
                "1 Bell Pepper (Hoho)",
                "2 Carrots",
                "Beef Masala",
                "Salt"
            ),
            instructions = listOf(
                "Peel the matoke and soak in water to prevent browning.",
                "Boil beef until tender.",
                "Fry onions and hoho, then add tomatoes and carrots. Cook until soft.",
                "Add beef and matoke. Season with salt and beef masala.",
                "Add water to cover and simmer until matoke is soft and the sauce thickens.",
                "Serve hot."
            ),
            estimatedCost = 500,
            webUrl = null,
            category = "Popular"
        )
    )

    suspend fun seedDatabase() = withContext(Dispatchers.IO) {
        kenyanRecipes.forEach { recipe ->
            try {
                repository.createRecipe(recipe)
            } catch (e: Exception) {
                println("Failed to insert recipe: ${recipe.title}")
            }
        }
    }
}
