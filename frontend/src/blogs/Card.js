import Button from "@material-ui/core/Button";
import ButtonBase from "@material-ui/core/ButtonBase";
import { makeStyles } from "@material-ui/core/styles";
import Grid from "@mui/material/Grid";
import Paper from "@mui/material/Paper";
import Typography from "@mui/material/Typography";
import React from "react";
import { Link, Route } from "react-router-dom";

const message = `Truncation should be conditionally applicable on this long line of text
 as this is a much longer line than what the container can support. `;

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  paper: {
    padding: theme.spacing(2),
    // margin: "auto",
    marginBottom: 10,
    // maxWidth: 500,
  },
  image: {
    width: 194,
    height: 162,
  },
  img: {
    margin: "auto",
    display: "block",
    maxWidth: "100%",
    maxHeight: "100%",
  },
}));

export default function Card(props) {
  const convertNumberToDate = (value) => {
    console.log(value);
    var date = new Date(value);
    console.log(date);

    return date.toDateString();
  };

  const classes = useStyles();
  return (
    <div className={classes.root}>
      <Paper className={classes.paper}>
        <Grid container spacing={2}>
          <Grid item>
            <ButtonBase className={classes.image}>
              <img
                className={classes.img}
                alt="complex"
                src={props.blogPicture}
              />
            </ButtonBase>
          </Grid>
          <Grid item xs={12} sm container>
            <Grid item xs container direction="column" spacing={2}>
              <Grid item xs>
                <Typography gutterBottom variant="subtitle1">
                  {props.blogName}
                </Typography>
                <Typography variant="body2" gutterBottom>
                  {convertNumberToDate(props.blogDate)}
                </Typography>
                <Typography variant="body2" gutterBottom>
                  {props.blogIntroduction}
                </Typography>
                <Route>
                  <Link to={props.link} style={{ textDecoration: "none" }}>
                    <Button variant="contained" color="primary">
                      Read More
                    </Button>
                  </Link>
                </Route>
              </Grid>
            </Grid>
          </Grid>
        </Grid>
      </Paper>
    </div>
  );
}
