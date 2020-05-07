import React, { Component } from "react";
import BlogItem from "./BlogItem";
import { connect } from "react-redux";
import { fetchBlogs } from "../../actions/blog";
class BlogList extends Component {
  componentDidMount() {
    this.props.fetchBlogs();
  }
  //省略了prop-types
  render() {
    const { list, isLoading, errMsg } = this.props;
    console.log(this.props);
    return isLoading ? (
      <div>Loading</div>
    ) : (
      <div>
        {errMsg === "" ? (
          <ul>
            {list.map(blog => {
              return <BlogItem key={blog.id} {...blog} />;
            })}
          </ul>
        ) : (
          <h1>{errMsg}</h1>
        )}
      </div>
    );
  }
}

const mapState = state => ({
  list: state.blog.list,
  isLoading: state.blog.isLoading,
  errMsg: state.blog.errMsg
});
export default connect(mapState, { fetchBlogs })(BlogList);
