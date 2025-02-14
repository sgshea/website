import { defineCollection, z } from 'astro:content'

const blog = defineCollection({
    type: 'content',
    // Type-check frontmatter using a schema
    schema: z.object({
        title: z.string(),
        description: z.string(),
        // Transform string to Date object
        pubDate: z.coerce.date(),
        lastDate: z.coerce.date().optional(),
        stillActive: z.boolean().default(false),
        updatedDate: z.coerce.date().optional(),
        heroImage: z.string().optional(),
        tags: z.array(z.string()).optional(),
        demo: z.string().optional(),
        source: z.string().optional(),
    }),
})


export const collections = { blog }

