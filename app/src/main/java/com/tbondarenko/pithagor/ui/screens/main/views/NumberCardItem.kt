package com.tbondarenko.pithagor.ui.screens.main.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tbondarenko.pithagor.R
import com.tbondarenko.pithagor.ui.screens.main.models.NumberCardItemModel
import com.tbondarenko.pithagor.ui.theme.PithagorTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NumberCardItem(
    modifier: Modifier = Modifier,
    model: NumberCardItemModel,
    onCardItemClick: ((Int) -> Unit)
) {
    Card(
        onClick = {onCardItemClick(model.numberId)},
        modifier = Modifier
            .fillMaxWidth()
            .padding(PithagorTheme.shape.padding),
        shape = PithagorTheme.shape.cornerStyle,
        elevation = 8.dp,
        backgroundColor = PithagorTheme.colors.secondaryBackground
    ) {

        var expended by rememberSaveable { mutableStateOf(false) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(1.2f)
                    .padding(
                        start = PithagorTheme.shape.padding,
                        end = PithagorTheme.shape.padding,
                    ),
                text = model.numberId.toString(),
                color = PithagorTheme.colors.primaryText,
                style = PithagorTheme.typography.cardTitle,
                textAlign = TextAlign.Center,
                softWrap = false
            )

            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(4.dp),
                color = PithagorTheme.colors.primaryBackground,
            )

            Column(
                modifier = Modifier
                    .weight(3f)
                    .padding(
                        top = PithagorTheme.shape.padding,
                        bottom = PithagorTheme.shape.padding
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (expended) {
                    (model.numberDescription).forEach {
                        Text(
                            text = it,
                            color = PithagorTheme.colors.primaryText,
                            style = PithagorTheme.typography.body
                        )
                        Spacer(modifier = Modifier.padding(PithagorTheme.shape.padding / 4))
                    }
                } else {
                    (model.numberDescription).take(2).forEach {
                        Text(
                            text = it,
                            color = PithagorTheme.colors.primaryText,
                            style = PithagorTheme.typography.body
                        )
                        Spacer(modifier = Modifier.padding(PithagorTheme.shape.padding / 4))
                    }
                    Text(
                        text = "...",
                        color = PithagorTheme.colors.primaryText,
                        style = PithagorTheme.typography.body
                    )
                }
            }
            IconButton(
                modifier = Modifier.align(Alignment.Top),
                onClick = { expended = !expended }) {
                Icon(
                    tint = PithagorTheme.colors.accentColor,
                    imageVector = if (!expended) Icons.Filled.ExpandMore
                    else Icons.Filled.ExpandLess,
                    contentDescription = if (!expended) stringResource(R.string.card_button_expend_off)
                    else stringResource(id = R.string.card_button_expend_on)
                )
            }
        }
    }
}
