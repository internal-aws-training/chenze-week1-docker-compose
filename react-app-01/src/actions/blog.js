import actionTypes from "./actionTypes";
import { getPosts } from "../services";
const startFetchBlogs = () => {
  return {
    type: actionTypes.START_FETCH_BLOGS
  };
};
const fetchBlogsFailed = () => {
  return {
    type: actionTypes.FETCH_BLOGS_FAILED
  };
};
const fetchBlogSuccess = (payload) => {
  return {
    type: actionTypes.FETCH_BLOGS_SUCCESS,
    payload: payload
  };
};

export const fetchBlogs = () => dispatch => {
  dispatch(startFetchBlogs());
  getPosts()
    .then(res => {
      console.log("res", res);
      //to try the err
      if (res.status === 200) {
        dispatch(
          fetchBlogSuccess({
            list: res.data
          })
        );
      } else {
        dispatch(fetchBlogsFailed());
      }
    })
    .catch(err => {
      console.log(err);
      dispatch(fetchBlogsFailed());
    });
};
