import * as React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { CardActionArea } from "@mui/material";
import Avatar from "@material-ui/core/Avatar";
import { makeStyles } from "@material-ui/core/styles";
import FacebookIcon from "@mui/icons-material/Facebook";
import TwitterIcon from "@mui/icons-material/Twitter";

import CardActions from "@material-ui/core/CardActions";
import IconButton from "@material-ui/core/IconButton";

const useStyles = makeStyles((theme) => ({
  root: {
    textAlign: "left",
  },
  large: {
    width: theme.spacing(21),
    height: theme.spacing(21),
    margin: "auto",
  },
  text: {},
}));

function Author(props) {
  const classes = useStyles();
  return (
    <Card sx={{ maxWidth: 340 }} className={classes.root}>
      <CardActionArea>
        <Avatar
          className={classes.large}
          src="https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
        />
        <CardContent>
          <Typography gutterBottom variant="h6" component="div">
            Denali is a simple resposive blog template. Easily add new posts
            using the Editor or change layout and design using the Designer.
            <hr />
            Featured Posts
          </Typography>
          <Typography variant="body2" color="text.secondary">
            According a funnily until pre-set or arrogant well cheerful <br />{" "}
            <br />
            Overlaid the jeepers uselessly much excluding the
            <hr />
          </Typography>
        </CardContent>
        <CardActions disableSpacing>
          <IconButton aria-label="facebook">
            <FacebookIcon />
          </IconButton>
          <IconButton aria-label="twitter">
            <TwitterIcon />
          </IconButton>
        </CardActions>
      </CardActionArea>
    </Card>
  );
}
export default Author;
