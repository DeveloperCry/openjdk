/*
 * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * COPYRIGHT AND PERMISSION NOTICE
 *
 * Copyright (c) 1991-2020 Unicode, Inc. All rights reserved.
 * Distributed under the Terms of Use in https://www.unicode.org/copyright.html.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of the Unicode data files and any associated documentation
 * (the "Data Files") or Unicode software and any associated documentation
 * (the "Software") to deal in the Data Files or Software
 * without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, and/or sell copies of
 * the Data Files or Software, and to permit persons to whom the Data Files
 * or Software are furnished to do so, provided that either
 * (a) this copyright and permission notice appear with all copies
 * of the Data Files or Software, or
 * (b) this copyright and permission notice appear in associated
 * Documentation.
 *
 * THE DATA FILES AND SOFTWARE ARE PROVIDED "AS IS", WITHOUT WARRANTY OF
 * ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT OF THIRD PARTY RIGHTS.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR HOLDERS INCLUDED IN THIS
 * NOTICE BE LIABLE FOR ANY CLAIM, OR ANY SPECIAL INDIRECT OR CONSEQUENTIAL
 * DAMAGES, OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE,
 * DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER
 * TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR
 * PERFORMANCE OF THE DATA FILES OR SOFTWARE.
 *
 * Except as contained in this notice, the name of a copyright holder
 * shall not be used in advertising or otherwise to promote the sale,
 * use or other dealings in these Data Files or Software without prior
 * written authorization of the copyright holder.
 */

package sun.text.resources.cldr.ext;

import java.util.ListResourceBundle;

public class FormatData_sr_Latn_BA extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_DayNames = new String[] {
               "nedjelja",
               "ponedjeljak",
               "utorak",
               "srijeda",
               "\u010detvrtak",
               "petak",
               "subota",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "prije podne",
               "po podne",
               "pono\u0107",
               "podne",
               "ujutro",
               "",
               "po podne",
               "",
               "uve\u010de",
               "",
               "no\u0107u",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "a",
               "p",
               "pono\u0107",
               "podne",
               "jutro",
               "",
               "po pod.",
               "",
               "ve\u010de",
               "",
               "no\u0107",
               "",
            };
        final String[] metaValue_abbreviated_AmPmMarkers = new String[] {
               "prije podne",
               "po podne",
               "pono\u0107",
               "podne",
               "jutro",
               "",
               "po pod.",
               "",
               "ve\u010de",
               "",
               "no\u0107u",
               "",
            };
        final Object[][] data = new Object[][] {
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayNames },
            { "DayNames", metaValue_DayNames },
            { "field.month", "mjesec" },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "field.week", "nedjelja" },
            { "DayAbbreviations", metaValue_DayNames },
            { "abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "timezone.regionFormat.standard", "{0}, standardno vrijeme" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "roc.DayNames", metaValue_DayNames },
            { "standalone.DayAbbreviations",
                new String[] {
                    "ned",
                    "pon",
                    "uto",
                    "sri",
                    "\u010det",
                    "pet",
                    "sub",
                }
            },
            { "roc.AmPmMarkers", metaValue_AmPmMarkers },
            { "islamic.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "long.Eras",
                new String[] {
                    "prije nove ere",
                    "nove ere",
                }
            },
            { "islamic.DayNames", metaValue_DayNames },
            { "timezone.regionFormat.daylight", "{0}, ljetnje vrijeme" },
            { "buddhist.DayAbbreviations", metaValue_DayNames },
            { "field.weekday", "dan u nedjelji" },
            { "standalone.DayNames", metaValue_DayNames },
            { "narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.DayNames", metaValue_DayNames },
            { "islamic.DayAbbreviations", metaValue_DayNames },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "roc.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "field.dayperiod", "prije podne/po podne" },
            { "roc.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
        };
        return data;
    }
}
