import React from "react";
import {BookmarksResponse} from "@/services/model";
import Bookmark from "@/components/Bookmark";
import Pagination from "@/components/Pagination";

interface BookmarksProps {
    bookmarks: BookmarksResponse
    query?: string
}

const Bookmarks: React.FC<BookmarksProps> = ({bookmarks, query}) => (
    <div>
        <Pagination bookmarks={bookmarks} query={query}/>
        {bookmarks.data.map(b => <Bookmark key={b.id} bookmark={b}/>)}
    </div>
);

export default Bookmarks;