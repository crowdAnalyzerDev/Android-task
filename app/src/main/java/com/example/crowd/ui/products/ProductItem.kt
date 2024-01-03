package com.example.crowd.ui.products

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.example.crowd.R
import com.example.crowd.data.model.Product

@Composable
fun ProductItem(product: Product) {

    ConstraintLayout(
        Modifier
            .fillMaxWidth()
            .height(118.dp)
            .border(
                1.dp,
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                color = Color.Transparent, shape = RoundedCornerShape(8.dp)
            )
            .padding(1.dp)
            .clickable {

            }
    ) {
        val (image, name, beatsCount, contextMenuIcon) = createRefs()

        AsyncImage(
            model = product.photo_url,
            contentDescription = "",
            error = painterResource(id = R.drawable.ic_bookmark_placeholder),
            placeholder = painterResource(id = R.drawable.ic_bookmark_placeholder),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(126.dp)
                .height(118.dp)
                .clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp))
                .constrainAs(image) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )
        Text(
            text = "${product.name} product.name product.name product.name product.name product.name",
            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onBackground),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(start = 12.dp, top = 16.dp)
                .constrainAs(name) {
                    top.linkTo(parent.top)
                    start.linkTo(image.end)
                }
        )
        Text(
            text = "${product.price}",
            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onBackground),
            modifier = Modifier
                .padding(start = 12.dp, top = 8.dp)
                .constrainAs(beatsCount) {
                    top.linkTo(name.bottom)
                    start.linkTo(image.end)
                }
        )
        // Members view
        Icon(
            painter = painterResource(id = R.drawable.ic_bookmark),
            contentDescription = "menu dots",
            tint = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .padding(12.dp)
                .constrainAs(contextMenuIcon) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
        )


    }

}